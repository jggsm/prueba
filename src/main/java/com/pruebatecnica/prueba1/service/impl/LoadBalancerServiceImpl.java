package com.pruebatecnica.prueba1.service.impl;

import com.pruebatecnica.prueba1.service.LoadBalancerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The type Load balancer service.
 */
@Component
@Slf4j
public class LoadBalancerServiceImpl implements LoadBalancerService {

    /**
     * Checks if the list of integer can be balanced.
     *
     * @param dataList the data list
     * @return true if the data list can be balanced.
     */
    @Override
    //Se suprime regla de sonar al tratarse de una excepción.
    @SuppressWarnings("java:S5413")
    public Boolean canBeBalanced(List<Integer> dataList) {
        for (int i = 0; dataList.size() > i; i++) {
            for (int j = 0; dataList.size() > j; j++) {
                if (i < j) {
                    List<Integer> reducedList = new ArrayList<>(dataList);
                    reducedList.remove(j);
                    reducedList.remove(i);
                    double maxLoadValue = reducedList.stream().reduce(0, Integer::sum) / 3.0;
                    if (isInteger(maxLoadValue) && isBalanced(reducedList, (int) maxLoadValue)) {
                        log.info("There is a match in the dataList, remove positions -> "+i+" and "+j+" and balance the list: "+ reducedList);
                        return true;
                    }
                }
            }
        }
        return false;
    }


    /**
     * Check if the dataLoad is balanced.
     *
     * @param dataLoad     the list of data load to balance.
     * @param maxLoadValue the max load value
     * @return the boolean
     */
    private boolean isBalanced(List<Integer> dataLoad, int maxLoadValue) {
        boolean response = false;
        HashMap<Integer, Integer> usedLoad = new HashMap<>();

        for (int i = 0; dataLoad.size() > i; i++) {
            Integer currentLoad = dataLoad.get(i);
            int sumValue = 0;
            for (int j = 0; j < dataLoad.size(); j++) {
                if (i < j && !usedLoad.containsKey(j)) {
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
            if (usedLoad.size() == dataLoad.size()) {
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
