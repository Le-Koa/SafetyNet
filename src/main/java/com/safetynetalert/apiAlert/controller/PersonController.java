package com.safetynetalert.apiAlert.controller;


import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.exception.Exception;
import com.safetynetalert.apiAlert.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private static final Logger logger = LogManager.getLogger(PersonController.class);

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

   /* @GetMapping("/person")
    public List<Person> findAll() {
        logger.info("Request the list of all person to the endpoint");
        return personService.findAll();
    } */

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person) {
        logger.info("Request to create a person to the endpoint ", person);
        return personService.savePerson(person);
    }
    @Transactional
    @DeleteMapping("/person")
    public void deletePerson(@RequestParam String firstName, @RequestParam String lastName) {
        boolean existingPersonFirstNameLastName;
        logger.info("Request to delete a person to the endpoint", firstName, lastName);
        existingPersonFirstNameLastName = personService.personExist(firstName, lastName);
        if (existingPersonFirstNameLastName) {
            personService.deletePerson(firstName, lastName);
        }
    }

    @PutMapping("/person/{id}")
    public Person updatePerson(@PathVariable("id") Long id, @RequestBody Person person) {
        Person updatePers = null;
           boolean existsId = false;
        try {
           logger.info("Request to update an existing person to the endpoint", person);
           existsId = personService.personIdExist(id);
           if (existsId) {
               updatePers = personService.getPerson(id);
               if (updatePers != null) {
                   String address = person.getAddress();
                   if (address != null) {
                       updatePers.setAddress(address);
                   }
                   String city = person.getCity();
                   if (city != null) {
                       updatePers.setCity(city);
                   }
                   String zip = person.getZip();
                   if (city != null) {
                       updatePers.setZip(zip);
                   }
                   String phone = person.getPhone();
                   if (phone != null) {
                       updatePers.setPhone(phone);
                   }
                   String email = person.getEmail();
                   if (email != null) {
                       updatePers.setPhone(phone);
                   }
               }
               personService.savePerson(updatePers);
           }
       } catch (java.lang.Exception e) {
           logger.error("Error in the PersonInfoController in the method updatePerson :"
                   + e.getMessage());
       }

        if(!existsId){
            logger.error("This "+ id + " doesn't exist.");
            throw new Exception("This "+ id + " doesn't exist.");
        }
        return updatePers;
    }
}


