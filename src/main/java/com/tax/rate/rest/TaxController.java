package com.tax.rate.rest;

import com.tax.rate.model.TaxRequest;
import com.tax.rate.model.TaxResponse;
import com.tax.rate.service.TaxService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author Dhriti Ghosh
 */
@RestController
@RequestMapping(value = "/v1/tax/calculate")
@Slf4j
public class TaxController {

    @Autowired
    private TaxService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TaxResponse> setCallback(@RequestBody TaxRequest request) {
        return Mono.just(service.calculateTax(request));
    }
}
