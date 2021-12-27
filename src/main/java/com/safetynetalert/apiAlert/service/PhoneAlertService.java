package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PhoneAlertService {

    List<String> phoneListFromPersonList(List<Person> personList);

    List<String> PhoneNumberListFromFirestation(String firestation);
}
