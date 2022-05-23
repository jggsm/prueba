package com.pruebatecnica.prueba1.service;

import org.springframework.web.bind.annotation.RequestParam;

/**
 * The interface Alliteration service.
 */
public interface AlliterationService {

    /**
     * Calculate alliteration percentange string.
     *
     * @param requestTest the request test
     * @return the string
     */
    String calculateAlliterationPercentange(@RequestParam String requestTest);
}
