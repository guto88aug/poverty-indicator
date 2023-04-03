package com.github.guto88aug.api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.guto88aug.api.domain.deserialize.CountryDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = CountryDeserialize.class)
public class PaginationCountryDTO {

    private PaginationDTO pagination;

    private List<CountryDTO> countries;

}
