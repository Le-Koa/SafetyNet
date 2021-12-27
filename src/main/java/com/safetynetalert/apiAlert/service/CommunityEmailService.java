package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommunityEmailService {

    List<String> getEmailFromPersonList(List<Person> personList);

    List<String> getEmailFromCity (String city);
}
