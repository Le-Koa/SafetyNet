package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.PersonInfo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PersonInfoService {

    List<Person> PersonListByFirstAndLastName (String firstName, String lastName);

    List<Person> personListBylastName(String lastName);

    void setAgeAndMedicationsAndAllergies(List<Person> personList, LocalDate date);

    List<PersonInfo>getPersonListByFirstNameAndLastNameThenOnlyLastName(String firstName, String lastName);


}
