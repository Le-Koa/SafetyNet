package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.PersonInfo;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonInfoServiceImpl implements  PersonInfoService{
    private static final Logger logger = LogManager.getLogger(PersonInfoServiceImpl.class);

    private final PersonRepository personRepository;

    private final MedicalRecordRepository medicalRecordRepository;

    private final DTOService dtoService;

    public PersonInfoServiceImpl(PersonRepository personRepository, MedicalRecordRepository medicalRecordRepository, DTOService dtoService) {
        this.personRepository = personRepository;
        this.medicalRecordRepository = medicalRecordRepository;
        this.dtoService = dtoService;
    }

    @Override
    public List<Person> PersonListByFirstAndLastName(String firstName, String lastName) {
        logger.warn("Method PersonListByFirstAndLastName , Class PersonInfoServiceImpl");
        List<Person> personList = null;
         personList = personRepository.findByFirstNameAndLastNameAllIgnoreCase(firstName, lastName);
         setAgeAndMedicationsAndAllergies(personList, LocalDate.now());
        return personList;
    }

    @Override
    public List<Person> personListBylastName(String lastName) {
        logger.warn("Method personListBylastName  , Class PersonInfoServiceImpl");
        List<Person> personList = null;
        personList = personRepository.findByLastName(lastName);
        setAgeAndMedicationsAndAllergies(personList, LocalDate.now());
        return personList;
    }

    @Override
    public void setAgeAndMedicationsAndAllergies(List<Person> personList, LocalDate date) {
        logger.warn("Method setAgeAndMedicationsAndAllergies , Class PersonInfoServiceImpl");
    personList.forEach(personIt -> {
        medicalRecordRepository.findByFirstNameAndLastName( personIt.getFirstName(), personIt.getLastName()).forEach(
                medicalRecordIt -> {
                    if (medicalRecordIt.getBirthdate() != null && !medicalRecordIt.getBirthdate().isEmpty()) {
                        personIt.setAge(medicalRecordIt.getBirthdate(), LocalDate.now());
                        personIt.setMedicationAndAllergies(medicalRecordIt);
                    }
                }
        );
    } );
    }

    @Override
    public List<PersonInfo> getPersonListByFirstNameAndLastNameThenOnlyLastName(String firstName, String lastName) {
        logger.warn("Method getPersonListByFirstNameAndLastNameThenOnlyLastName , Class PersonInfoServiceImpl");
        List<PersonInfo> personInfoList = null;
                try {
                    List<Person> personInfoByLastName = personListBylastName(lastName);
                    List<Person> personInfoByFirstNameAndLastName= PersonListByFirstAndLastName(firstName,lastName);
                    personInfoByLastName.forEach(personIt ->{
                        if (!personInfoByFirstNameAndLastName.contains(personIt))
                            personInfoByFirstNameAndLastName.add(personIt);
                    } );
                    personInfoList = dtoService.PersonInfoDTO(personInfoByFirstNameAndLastName);
                } catch (Exception e) {
                    logger.error("Error when we try to get PersonList By FirstName And LastName Then Only LastName :"
                            + e.getMessage());
                }
        return personInfoList;
    }

}
