package com.github.guto88aug.api.controller;

import com.github.guto88aug.api.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/world-bank")
@Api(value = "API REST Produtos")
@AllArgsConstructor
public class WorldBankController {

    private final CountryService countryService;

    @ApiOperation(value = "Retorna os países para consulta")
    @GetMapping("/countries/{currentPage}/{perPage}")
    public ResponseEntity getCountry(@DefaultValue("1") @PathVariable(name = "currentPage") final Integer currentPage,
                                     @DefaultValue("50") @PathVariable(name = "perPage") final Integer perPage) {
        log.info("iniciando consulta dos países disponíveis no banco mundial");
        return ResponseEntity.ok().body(countryService.getCountries(currentPage, perPage));
    }

    @ApiOperation(value = "Retorna pelo parametro do país")
    @GetMapping("/indicator/{codeCountry}/{currentPage}/{perPage}")
    public ResponseEntity getPovertyIndicator(@PathVariable(name = "codeCountry", required = true) String codeCountry,
                                              @DefaultValue("1") @PathVariable(name = "currentPage") final Integer currentPage,
                                              @DefaultValue("50") @PathVariable(name = "perPage") final Integer perPage) {
        log.info("iniciando consulta por código do país disponíveis no banco mundial");
        return ResponseEntity.ok(countryService.getIndicator(codeCountry, currentPage, perPage));
    }


}
