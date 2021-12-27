package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.service.PhoneAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PhoneAlertController {
    private static final Logger logger = LogManager.getLogger(PhoneAlertController.class);

    public final PhoneAlertService phoneAlertService;

    public PhoneAlertController(PhoneAlertService phoneAlertService) {
        this.phoneAlertService = phoneAlertService;
    }

    @GetMapping("/phoneAlert")
    public List<String> phoneNumberByStation (@RequestParam String firestation){
        List<String> phoneList = null;
        logger.info("Request the phone number of a person to the endpoint", firestation);
        try {
            phoneList = phoneAlertService.PhoneNumberListFromFirestation(firestation);
        } catch ( Exception e) {
            logger.error("Method phoneNumberByStation, Class PhoneAlertController");
        }
        return phoneList;
    }

}
