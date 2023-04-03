package com.github.guto88aug.api.handler;

import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationIndicatorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface IWorldBankCountryHandler {

    @GetMapping("/v2/country?format=json")
    PaginationCountryDTO getCountries(@RequestParam("page") Integer currentPage
            , @RequestParam("per_page") Integer perPage);


    @GetMapping("/v2/country/{id}/indicator/SI.POV.DDAY?format=json")
    PaginationIndicatorDTO getIndicator(@RequestParam("id") String id
            , @RequestParam("page") Integer currentPage
            , @RequestParam("per_page") Integer perPage);


}
