package com.safetynetalert.apiAlert.controller;


import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.service.FirestationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirestationController {
    private static final Logger logger = LogManager.getLogger(FirestationController.class);

    private final FirestationService firestationService;


    public FirestationController(FirestationService firestationService) {
        this.firestationService = firestationService;
    }
    @PostMapping("/firestation")
    public Firestation addFirestation (@RequestBody Firestation firestation) {
        logger.info("Request to add and save a firestation ", firestation);
        return firestationService.saveFirestation(firestation);
    }
    @PutMapping("/firestation")
    public Firestation updateFirestation (@RequestParam String address, @RequestParam String station, @RequestBody Firestation firestation) {
        Firestation updateFirestation;
        updateFirestation = firestationService.getFirestation(address, station);
        logger.info("Request to update and save an existing firestation", address , station ,firestation);
        if (updateFirestation != null) {
            String newStationNumber = firestation.getStation();
            if (newStationNumber != null) {
                updateFirestation.setStation(newStationNumber);
            }
            firestationService.saveFirestation(updateFirestation);
        }
        return updateFirestation;
    }
    @Transactional
    @DeleteMapping("/firestation")
    public void deleteFirestation(@RequestParam String address, @RequestParam String station) throws Exception {
        boolean existingFirestation = false;
        try {
            logger.info("Request to delete an existing firestation", address, station);
            if (!existingFirestation) {
                firestationService.deleteFirestationByAddress(address);
                firestationService.deleteFirestationByStation(station);
                firestationService.deleteFirestationByStationAndAddress(address, station);
            }
        } catch (java.lang.Exception e) {
            logger.error("Error in the FireStationController in the method deleteFireStation :"
                    + e.getMessage());
        }
    }
}
