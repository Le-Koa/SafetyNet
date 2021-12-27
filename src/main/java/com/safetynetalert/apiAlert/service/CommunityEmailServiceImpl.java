package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityEmailServiceImpl implements CommunityEmailService{
    private static final Logger logger = LogManager.getLogger(CommunityEmailServiceImpl.class);

    public final PersonRepository personRepository;

    public CommunityEmailServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<String> getEmailFromPersonList(List<Person> personList) {
        logger.warn("Method getEmailFromPersonList , Class CommunityEmailServiceImpl");
        List<String> listOfEmail = new ArrayList<>();
        if (personList != null) {
            personList.forEach(personIt -> {
                if(personIt.getEmail() != null && !personIt.getEmail().isEmpty()) {
                    listOfEmail.add(personIt.getEmail());
                }
            } );
        }
        return listOfEmail;
    }

    @Override
    public List<String> getEmailFromCity(String city) {
        logger.warn("Method getEmailFromCity , Class CommunityEmailServiceImpl");
        List<Person> personList = personRepository.findByCity(city);
        List<String> emailList = getEmailFromPersonList(personList);

        return emailList;
    }
}
