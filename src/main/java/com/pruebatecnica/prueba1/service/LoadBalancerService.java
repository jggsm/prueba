package com.pruebatecnica.prueba1.service;

import java.util.List;

public interface LoadBalancerService {

    Boolean canBeBalanced(List<Integer> dataList);
}
