package com.pruebatecnica.prueba1.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * The interface Load balancer service.
 */
public interface LoadBalancerService {

    /**
     * Can be balanced boolean.
     *
     * @param dataList the data list
     * @return the boolean
     */
    Boolean canBeBalanced(@RequestParam List<Integer> dataList);
}
