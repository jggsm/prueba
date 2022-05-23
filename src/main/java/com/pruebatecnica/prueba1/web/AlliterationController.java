package com.pruebatecnica.prueba1.web;

import com.pruebatecnica.prueba1.service.AlliterationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class AlliterationController {

    @Autowired
    private AlliterationService service;


    @GetMapping(path = "/alliterate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAlliterationPercent(@RequestParam String requestText) {
        return service.calculateAlliterationPercentange(requestText);
    }
}
