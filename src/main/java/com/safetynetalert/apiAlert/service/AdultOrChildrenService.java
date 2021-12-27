package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface AdultOrChildrenService {

    Map<String, List<Person>> listOfAllAdultAndChildren(List<Person> personList,
                                                               List<Person> adultList,
                                                               List<Person> childrenList);
}
