package com.github.guto88aug.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryDTO {

    private String id;
    private String iso2Code;
    private String name;
    private String longitude;
    private String latitude;

    private String capitalCity;

}