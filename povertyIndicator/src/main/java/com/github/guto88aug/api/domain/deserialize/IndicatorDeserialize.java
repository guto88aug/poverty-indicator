package com.github.guto88aug.api.domain.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.github.guto88aug.api.domain.dto.*;
import com.github.guto88aug.api.exception.PovertyIndicatorException;
import feign.FeignException;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

public class IndicatorDeserialize extends JsonDeserializer<PaginationIndicatorDTO> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public PaginationIndicatorDTO deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException, PovertyIndicatorException {
        final var objectCodec = jsonParser.getCodec();
        final var treeNode = (JsonNode) objectCodec.readTree(jsonParser);

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List json = mapper.readerFor(new TypeReference<List<Object>>() {
        }).readValue(treeNode);
        final var pagination = (LinkedHashMap<String, Object>) json.get(0);

        if (Objects.nonNull(pagination.get("message"))) {
            throw new PovertyIndicatorException("Code Country passado incorretamente.", HttpStatus.BAD_REQUEST);
        }

        final var paginationDTO = PaginationDTO
                .builder()
                .total(String.valueOf(pagination.get("total")))
                .countPage(String.valueOf(pagination.get("pages")))
                .perPage(String.valueOf(pagination.get("per_page")))
                .page(String.valueOf(pagination.get("page")))
                .build();

        final var indicators = (ArrayList<LinkedHashMap<String, Object>>) json.get(1);

        List<IndicatorDTO> indicatorDTOS = indicators.stream().map(value -> {
            final var indicator = IndicatorDTO.builder().build();
            indicator.setIndicator(new BaseDTO((LinkedHashMap) value.get("indicator")));
            indicator.setCountry(new BaseDTO((LinkedHashMap) value.get("country")));
            indicator.setCountryIso3Code((String) value.get("countryiso3code"));
            indicator.setDate((String) value.get("date"));
            indicator.setUnit((String) value.get("unit"));
            indicator.setObsStatus((String) value.get("obs_status"));
            indicator.setDecimal((Integer) value.get("decimal"));
            indicator.setValue(Objects.nonNull(value.get("value")) ? String.valueOf(value.get("value")) : "");
            return indicator;
        }).sorted(comparing(IndicatorDTO::getDate).reversed()).collect(toList());

        final var response = PaginationIndicatorDTO.builder().build();
        response.setIndicators(indicatorDTOS);
        response.setPagination(paginationDTO);
        return response;
    }
}
