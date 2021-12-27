package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.ChildAndAdultDTO;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.ChildAlertDTO;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ChildAlertServiceImpl implements ChildAlertService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    private final DTOService dtoService;
    private final PersonRepository personRepository;
    private final AdultOrChildrenService adultOrChildrenService;

    public ChildAlertServiceImpl(DTOService dtoService, PersonRepository personRepository, AdultOrChildrenService adultOrChildrenService) {
        this.dtoService = dtoService;
        this.personRepository = personRepository;
        this.adultOrChildrenService = adultOrChildrenService;
    }

    @Override
    public ChildAndAdultDTO adultAndChildrenList(String address) {
        logger.warn("Method adultAndChildrenList, Class ChildAlertServiceImpl");
        ChildAndAdultDTO childAndAdultDTO = null;
        try {
            List<Person> filterpersonList = personRepository.findDistinctByAddress(address);
            List<Person> childrenList = new ArrayList<>();
            List<Person> adultList = new ArrayList<>();

            Map<String, List<Person>> map = adultOrChildrenService.listOfAllAdultAndChildren(filterpersonList, childrenList, adultList);

            List<ChildAlertDTO> childAlertsListDTO = dtoService.ChildAlertDTO(map.get("childrenList"));
            List<ChildAlertDTO> adultAlertsList = dtoService.ChildAlertDTO(map.get("adultList"));

            childAndAdultDTO = new ChildAndAdultDTO(childAlertsListDTO, adultAlertsList);
            if (childrenList.isEmpty()) {
                return new ChildAndAdultDTO(new ArrayList<>(), new ArrayList<>());
            }
            } catch (Exception e){
            logger.error("Error getting ChildrenList And AdultList From an address :" + e.getMessage());
            }
            return childAndAdultDTO;
        }
    }

