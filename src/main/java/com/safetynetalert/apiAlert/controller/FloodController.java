package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.FloodFireDTO;
import com.safetynetalert.apiAlert.service.FloodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FloodController {
    private static final Logger logger = LogManager.getLogger(FloodController.class);

    private final FloodService floodService;

    public FloodController(FloodService floodService) {
        this.floodService = floodService;
    }

    @GetMapping("/flood")
    public List<FloodFireDTO> getPersonFromStation (@RequestParam List<String> stations) {
        List<FloodFireDTO>addressListOfPerson;
        logger.info("Request person information fron a list of station", stations);
        addressListOfPerson = floodService.getInfoByAddress(stations);
        return addressListOfPerson;
    }
}
