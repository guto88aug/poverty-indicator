package com.github.guto88aug.api.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaginationDTO {

    private String page = "0";
    private String countPage = "0";
    private String total = "0";
    private String perPage = "0";
}
