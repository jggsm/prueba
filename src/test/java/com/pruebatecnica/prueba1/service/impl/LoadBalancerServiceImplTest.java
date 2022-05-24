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
    private LoadBalancerServiceImpl service;


    @Test
    public void calculateAlliterationPercentangeTest() {
        List<Integer> lista = new ArrayList<>(
                Arrays.asList(1,3,4,2,2,12,2,1,1,2)
        );

        Assertions.assertEquals(true, service.canBeBalanced(lista));
    }

    @Test
    public void exerciseTest2() {
        List<Integer> lista = new ArrayList<>(
                Arrays.asList(1,1,1,1,1,1)
        );

        Assertions.assertEquals(false, service.canBeBalanced(lista));
    }

    @Test
    public void exerciseTest1() {
        List<Integer> lista = new ArrayList<>(
                Arrays.asList(1,3,4,2,2,2,1,1,2)
        );

        Assertions.assertEquals(true, service.canBeBalanced(lista));
    }

    @Test
    public void exerciseTest3231() {
        List<Integer> lista = new ArrayList<>(
                Arrays.asList(1,3,4,2,2,2,1,1,2,10,12,10,10,2,3,4,1,4,2,7,8,6,4)
        );

        Assertions.assertEquals(true, service.canBeBalanced(lista));
    }

}