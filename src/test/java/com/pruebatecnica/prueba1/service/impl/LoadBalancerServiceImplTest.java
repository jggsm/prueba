package com.pruebatecnica.prueba1.service.impl;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class LoadBalancerServiceImplTest {


    @InjectMocks
    LoadBalancerServiceImpl service;


    @Test
    public void calculateAlliterationPercentangeTest() {
        List<Integer> lista = new ArrayList<>(
                Arrays.asList(1,3,2,2,1,1,2)
        );

        Assertions.assertEquals(true, service.canBeBalanced(lista));
    }

}