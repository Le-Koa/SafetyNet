package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.service.CommunityEmailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {
    private static final Logger logger = LogManager.getLogger(CommunityEmailController.class);

    private final CommunityEmailService communityEmailService;

    public CommunityEmailController(CommunityEmailService communityEmailService) {
        this.communityEmailService = communityEmailService;
    }

    @GetMapping("/communityEmail")
    public List<String> getCommunityEmail(@RequestParam String city){

        List<String> listofMail = communityEmailService.getEmailFromCity(city);
        logger.info("Request a list of mail from a specified city to a endpoint", city);
        return listofMail;
    }

}
