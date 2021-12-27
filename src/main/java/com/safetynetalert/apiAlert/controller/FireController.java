package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.Fire;
import com.safetynetalert.apiAlert.service.FireService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FireController {
    private static final Logger logger = LogManager.getLogger(FireController.class);

    public final FireService fireService;


    public FireController(FireService fireService) {
        this.fireService = fireService;
    }

    @GetMapping("/fire")
    public Fire getFire(@RequestParam String address){
        Fire fire;
        fire = fireService.PersonListWithStationNumber(address);
        logger.info("Request a list of person and a list of station number to a endpoint", address);
        return fire;
    }

}
