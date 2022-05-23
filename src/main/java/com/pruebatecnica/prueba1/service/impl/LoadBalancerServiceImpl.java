package com.pruebatecnica.prueba1.service.impl;

import com.pruebatecnica.prueba1.service.LoadBalancerService;

import java.util.HashMap;
import java.util.List;

/**
 * The type Load balancer service.
 */
public class LoadBalancerServiceImpl implements LoadBalancerService {

    /**
     * Can be balanced boolean.
     *
     * @param dataList the data list
     * @return the boolean
     */
    @Override
    public Boolean canBeBalanced(List<Integer> dataList) {
        Boolean response = false;

        Double maxLoadValue = dataList.stream().reduce(0, Integer::sum) / 3.0;
        if (isInteger(maxLoadValue)) {
            response = isBalanced(dataList, maxLoadValue.intValue());
        }
        System.out.println(maxLoadValue);
        return response;
    }


    private boolean isBalanced(List<Integer> dataLoad, int maxLoadValue) {
        boolean response = false;
        HashMap<Integer,Integer> usedLoad = new HashMap<>();

        for (int i = 0; dataLoad.size() > i; i++) {
            Integer currentLoad = dataLoad.get(i);
            int sumValue = 0;
            for (int j = 0; j < dataLoad.size(); j++){
                if (!(i == j || usedLoad.containsKey(j))) {
                    sumValue = currentLoad + dataLoad.get(j);
                    if (sumValue == maxLoadValue) {
                        usedLoad.put(j, dataLoad.get(j));
                        usedLoad.putIfAbsent(i, currentLoad);
                        break;
                    } else if (sumValue < maxLoadValue) {
                        usedLoad.put(j, dataLoad.get(j));
                        usedLoad.putIfAbsent(i, currentLoad);
                    }
                }
            }
            if(usedLoad.size()== dataLoad.size()){
                response = true;
            }

        }

        return response;
    }

    /**
     * Check if the passed argument is an integer value.
     *
     * @param number double
     * @return true if the passed argument is an integer value.
     */
    private boolean isInteger(double number) {
        return number % 1 == 0;
    }
}
