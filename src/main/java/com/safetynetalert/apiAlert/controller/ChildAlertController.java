package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.ChildAndAdultDTO;
import com.safetynetalert.apiAlert.service.ChildAlertService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChildAlertController {
    private static final Logger logger = LogManager.getLogger(PersonController.class);

    private final ChildAlertService childAlertService;

    public ChildAlertController(ChildAlertService childAlertService) {

        this.childAlertService = childAlertService;
    }


    @GetMapping("/childAlert")
    public ChildAndAdultDTO getFilter(@RequestParam String address){
        ChildAndAdultDTO childAndAdultDTO;
        childAndAdultDTO = childAlertService.adultAndChildrenList(address);
        logger.info("Request to a endpoint a list of children and a list of adult", address);
        return childAndAdultDTO;
    }

}
