package com.github.guto88aug.api.domain.deserialize;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryDeserializeTest {

    @Test
    public void deserialize() throws IOException {
        String json = "[\n" +
                "    {\n" +
                "        \"page\": 1,\n" +
                "        \"pages\": 6,\n" +
                "        \"per_page\": \"50\",\n" +
                "        \"total\": 299\n" +
                "    },\n" +
                "    [\n" +
                "        {\n" +
                "            \"id\": \"ABW\",\n" +
                "            \"iso2Code\": \"AW\",\n" +
                "            \"name\": \"Aruba\",\n" +
                "            \"region\": {\n" +
                "                \"id\": \"LCN\",\n" +
                "                \"iso2code\": \"ZJ\",\n" +
                "                \"value\": \"Latin America & Caribbean \"\n" +
                "            },\n" +
                "            \"adminregion\": {\n" +
                "                \"id\": \"\",\n" +
                "                \"iso2code\": \"\",\n" +
                "                \"value\": \"\"\n" +
                "            },\n" +
                "            \"incomeLevel\": {\n" +
                "                \"id\": \"HIC\",\n" +
                "                \"iso2code\": \"XD\",\n" +
                "                \"value\": \"High income\"\n" +
                "            },\n" +
                "            \"lendingType\": {\n" +
                "                \"id\": \"LNX\",\n" +
                "                \"iso2code\": \"XX\",\n" +
                "                \"value\": \"Not classified\"\n" +
                "            },\n" +
                "            \"capitalCity\": \"Oranjestad\",\n" +
                "            \"longitude\": \"-70.0167\",\n" +
                "            \"latitude\": \"12.5167\"\n" +
                "        }\n" +
                "       \n" +
                "    ]\n" +
                "]";

        PaginationCountryDTO response = new ObjectMapper().readValue(json, PaginationCountryDTO.class);

        assertEquals("6", response.getPagination().getCountPage());
        assertEquals(1, response.getCountries().size());
    }

}
