package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.StationNumberFirestationDTO;
import com.safetynetalert.apiAlert.service.AddressFromStationNumberService;
import com.safetynetalert.apiAlert.service.StationNumberService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationNumberController {
    private static final Logger logger = LogManager.getLogger(StationNumberController.class);

    private final StationNumberService stationNumberService;


    public StationNumberController(StationNumberService stationNumberService, AddressFromStationNumberService addressFromStationNumberService) {
        this.stationNumberService = stationNumberService;
    }


    @GetMapping("/firestation")
    public StationNumberFirestationDTO getStationNumberFirestation(@RequestParam String stationNumber){
        StationNumberFirestationDTO stationNumberFirestationDTO;
        logger.info("Request the station number to the endpoint", stationNumber);
        stationNumberFirestationDTO = stationNumberService.getPersonsDetailsFromStationNumber(stationNumber);
        return stationNumberFirestationDTO;
    }

}
