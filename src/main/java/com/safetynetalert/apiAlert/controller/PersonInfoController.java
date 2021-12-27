package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.PersonInfo;
import com.safetynetalert.apiAlert.service.PersonInfoService;
import com.safetynetalert.apiAlert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonInfoController {
    private static final Logger logger = LogManager.getLogger(PersonInfoController.class);

     private final PersonService personService;

     private final PersonInfoService personInfoService;

    public PersonInfoController(PersonService personService, PersonInfoService personInfoService) {
        this.personService = personService;
        this.personInfoService = personInfoService;
    }

    @GetMapping("/personInfo")
    public List<PersonInfo> getPersonInfo (@RequestParam String firstName, @RequestParam String lastName) {
        List<PersonInfo> personInfoList = null;

        logger.info("Request specific information from a person to a endpoint", firstName ,lastName);

        personInfoList = personInfoService.getPersonListByFirstNameAndLastNameThenOnlyLastName(firstName, lastName);


        return personInfoList;
    }
}
