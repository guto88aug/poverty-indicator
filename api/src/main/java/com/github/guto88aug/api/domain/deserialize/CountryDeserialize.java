package com.github.guto88aug.api.domain.deserialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.github.guto88aug.api.domain.dto.CountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CountryDeserialize extends JsonDeserializer<PaginationCountryDTO> {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public PaginationCountryDTO deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
        final var objectCodec = jsonParser.getCodec();
        final var treeNode = (JsonNode) objectCodec.readTree(jsonParser);

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        List json = mapper.readerFor(new TypeReference<List<Object>>() {
        }).readValue(treeNode);

        final var pagination = (LinkedHashMap<String, Object>) json.get(0);

        final var paginationDTO = PaginationDTO
                .builder()
                .total(String.valueOf(pagination.get("total")))
                .countPage(String.valueOf(pagination.get("pages")))
                .perPage(String.valueOf(pagination.get("per_page")))
                .page(String.valueOf(pagination.get("page")))
                .build();

        final var countries = (ArrayList<LinkedHashMap<String, Object>>) json.get(1);

        List<CountryDTO> countryDTOS = countries.stream().map(value -> {
            final var country = new CountryDTO();
            country.setName((String) value.get("name"));
            country.setIso2Code((String) value.get("iso2Code"));
            country.setId((String) value.get("id"));
            country.setCapitalCity((String) value.get("capitalCity"));
            country.setLatitude((String) value.get("latitude"));
            country.setLongitude((String) value.get("longitude"));
            return country;
        }).collect(toList());

        var response = PaginationCountryDTO
                .builder()
                .countries(countryDTOS)
                .pagination(paginationDTO)
                .build();

        return response;
    }
}
