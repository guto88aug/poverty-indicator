package com.github.guto88aug.api.service;

import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationDTO;
import com.github.guto88aug.api.domain.dto.PaginationIndicatorDTO;
import com.github.guto88aug.api.handler.IWorldBankCountryHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @InjectMocks
    CountryService service;

    @Mock
    IWorldBankCountryHandler iWorldBankCountryHandler;

    @Test
    void deveConsultarListaPaises() {
        PaginationCountryDTO experado = PaginationCountryDTO
                .builder()
                .pagination(
                        PaginationDTO
                                .builder()
                                .page("1")
                                .countPage("1")
                                .build())
                .build();

        doReturn(experado)
                .when(iWorldBankCountryHandler).getCountries(any(), any());

        PaginationCountryDTO paginationCountryDTO = service.getCountries(1, 1);

        assertEquals(experado.getPagination().getCountPage(), paginationCountryDTO.getPagination().getCountPage());
        assertEquals(experado.getPagination().getPage(), paginationCountryDTO.getPagination().getPage());


    }

    @Test
    void deveConsultarIndicadorPais() {
        PaginationIndicatorDTO experado = PaginationIndicatorDTO
                .builder()
                .pagination(
                        PaginationDTO
                                .builder()
                                .page("1")
                                .countPage("1")
                                .build())
                .build();

        doReturn(experado)
                .when(iWorldBankCountryHandler).getIndicator(any(), any(), any());

        PaginationIndicatorDTO paginationCountryDTO = service.getIndicator("BRA", 1, 1);

        assertEquals(experado.getPagination().getCountPage(), paginationCountryDTO.getPagination().getCountPage());
        assertEquals(experado.getPagination().getPage(), paginationCountryDTO.getPagination().getPage());


    }
}
