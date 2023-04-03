package com.github.guto88aug.api.service;

import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationIndicatorDTO;
import com.github.guto88aug.api.handler.IWorldBankCountryHandler;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CountryService {

    private final IWorldBankCountryHandler iWorldBankCountryHandler;

    public PaginationCountryDTO getCountries(Integer currentPage, Integer perPage) {
        return iWorldBankCountryHandler.getCountries(currentPage, perPage);
    }

    public PaginationIndicatorDTO getIndicator(String codeCountry, Integer currentPage, Integer perPage) {
        PaginationIndicatorDTO paginationIndicatorDTO = iWorldBankCountryHandler.getIndicator(codeCountry, currentPage, perPage);
        return paginationIndicatorDTO;
    }
}
