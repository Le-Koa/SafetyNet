package com.safetynetalert.apiAlert.service;


import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PersonService {

  //  List<Person> findAll();

    Person savePerson(Person person);

    void deletePerson(String firstName, String lastName);

    Person findPerson(String firstName, String lastName);

    Person getPerson (final Long id);

    boolean personExist(String firstName, String lastName);

    boolean personIdExist(Long id);

    boolean cityExist(String city);

    boolean addressExist(String address);



}
