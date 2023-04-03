package com.github.guto88aug.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class IndicatorDTO {

    private BaseDTO indicator;

    private BaseDTO country;

    private String countryIso3Code;
    private String date;
    private String value;
    private String unit;
    private String obsStatus;
    private Integer decimal;


}