package com.pruebatecnica.prueba1.web;

import com.pruebatecnica.prueba1.service.AlliterationService;
import com.pruebatecnica.prueba1.service.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Exercise controller.
 */
@Validated
@RestController
public class ExerciseController {

    /**
     * The Service.
     */
    private AlliterationService alliterationService;


    /**
     * The Service.
     */
    private LoadBalancerService loadBalancerService;

    /**
     * Instantiates a new Exercise controller.
     *
     * @param alliterationService the alliteration service
     * @param loadBalancerService the load balancer service
     */
    @Autowired
    public ExerciseController(AlliterationService alliterationService, LoadBalancerService loadBalancerService) {
        this.alliterationService = alliterationService;
        this.loadBalancerService = loadBalancerService;
    }

    /**
     * Gets alliteration percent.
     *
     * @param requestText the request text
     * @return the alliteration percent
     */
    @PostMapping(path = "/alliterate", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getAlliterationPercent(@RequestBody String requestText) {
        return alliterationService.calculateAlliterationPercentange(requestText);
    }


    /**
     * Gets balance.
     *
     * @param dataLoad the data load
     * @return the balance
     */
    @GetMapping(path = "/balance", produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean getBalance(@RequestParam List<Integer> dataLoad) {
        return loadBalancerService.canBeBalanced(dataLoad);
    }
}
