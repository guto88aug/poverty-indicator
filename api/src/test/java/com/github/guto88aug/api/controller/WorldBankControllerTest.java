package com.github.guto88aug.api.controller;

import com.github.guto88aug.api.domain.dto.PaginationCountryDTO;
import com.github.guto88aug.api.domain.dto.PaginationDTO;
import com.github.guto88aug.api.domain.dto.PaginationIndicatorDTO;
import com.github.guto88aug.api.exception.PovertyIndicatorException;
import com.github.guto88aug.api.service.CountryService;
import com.github.guto88aug.api.service.CountryServiceTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
public class WorldBankControllerTest {

    @InjectMocks
    WorldBankController controller;

    @Mock
    private CountryService countryService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void quandoGetCountryRetornar200() throws Exception {
        when(countryService.getCountries(any(), any()))
                .thenReturn(PaginationCountryDTO
                        .builder()
                        .pagination(PaginationDTO
                                .builder()
                                .build())
                        .build());
        MvcResult result = mockMvc.perform(
                get("/world-bank/countries/{currentPage}/{perPage}", 1, 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void quandoGetCountryRetornarException() throws Exception {
        doThrow(new PovertyIndicatorException("Teste", HttpStatus.INTERNAL_SERVER_ERROR))
                .when(countryService)
                .getCountries(any(), any());

        assertThrows(NestedServletException.class, () -> mockMvc.perform(
                get("/world-bank/countries/{currentPage}/{perPage}", 1, 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ));
    }

    @Test
    public void quandoGetIndicatorRetornar200() throws Exception {
        when(countryService.getIndicator(any(), any(), any()))
                .thenReturn(PaginationIndicatorDTO
                        .builder()
                        .pagination(PaginationDTO
                                .builder()
                                .build())
                        .build());

        MvcResult result = mockMvc.perform(
                get("/world-bank/indicator/{codeCountry}/{currentPage}/{perPage}", "BRA",1,10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void quandoGetIndicatorRetornarException() throws Exception {
        doThrow(new PovertyIndicatorException("Teste", HttpStatus.INTERNAL_SERVER_ERROR))
                .when(countryService)
                .getIndicator(any(), any(), any());

        assertThrows(NestedServletException.class, () -> mockMvc.perform(
                get("/world-bank/indicator/{codeCountry}/{currentPage}/{perPage}", "BRA",1,10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
        ));
    }
}
