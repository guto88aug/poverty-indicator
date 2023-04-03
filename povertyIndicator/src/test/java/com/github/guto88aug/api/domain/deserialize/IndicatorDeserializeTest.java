package com.github.guto88aug.api.domain.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationIndicatorDTO;
import com.github.guto88aug.api.exception.PovertyIndicatorException;
import feign.FeignException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IndicatorDeserializeTest {

    @Test
    public void deserialize() throws IOException {
        String json = "[\n" +
                "    {\n" +
                "        \"page\": 1,\n" +
                "        \"pages\": 2,\n" +
                "        \"per_page\": 50,\n" +
                "        \"total\": 62,\n" +
                "        \"sourceid\": \"2\",\n" +
                "        \"sourcename\": \"World Development Indicators\",\n" +
                "        \"lastupdated\": \"2023-03-30\"\n" +
                "    },\n" +
                "    [\n" +
                "        {\n" +
                "            \"indicator\": {\n" +
                "                \"id\": \"SI.POV.DDAY\",\n" +
                "                \"value\": \"Poverty headcount ratio at $2.15 a day (2017 PPP) (% of population)\"\n" +
                "            },\n" +
                "            \"country\": {\n" +
                "                \"id\": \"BR\",\n" +
                "                \"value\": \"Brazil\"\n" +
                "            },\n" +
                "            \"countryiso3code\": \"BRA\",\n" +
                "            \"date\": \"2021\",\n" +
                "            \"value\": 5.8,\n" +
                "            \"unit\": \"\",\n" +
                "            \"obs_status\": \"\",\n" +
                "            \"decimal\": 1\n" +
                "        }\n" +
                "     ]   \n" +
                "]";

        PaginationIndicatorDTO response = new ObjectMapper().readValue(json, PaginationIndicatorDTO.class);

        assertEquals("2", response.getPagination().getCountPage());
        assertEquals(1, response.getIndicators().size());
    }

    @Test
    public void deserializeException() throws IOException {
        String json = "[\n" +
                "    {\n" +
                "        \"message\": [\n" +
                "            {\n" +
                "                \"id\": \"120\",\n" +
                "                \"key\": \"Invalid value\",\n" +
                "                \"value\": \"The provided parameter value is not valid\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "]";

        assertThrows(PovertyIndicatorException.class, () -> new ObjectMapper().readValue(json, PaginationIndicatorDTO.class));
    }

}
