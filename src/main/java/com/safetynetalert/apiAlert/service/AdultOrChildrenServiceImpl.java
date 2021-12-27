package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdultOrChildrenServiceImpl implements AdultOrChildrenService {
    private static final Logger logger = LogManager.getLogger(AdultOrChildrenServiceImpl.class);

    private final MedicalRecordRepository medicalRecordRepository;

    public AdultOrChildrenServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    @Override
    public Map<String, List<Person>> listOfAllAdultAndChildren(List<Person> personList, List<Person> adultList, List<Person> childrenList) {
            logger.warn("Method listOfAllAdultAndChildren , Class AdultOrChildrenServiceImpl");
        try {
            personList.forEach(personIt -> {
                medicalRecordRepository.findByFirstNameAndLastName(personIt.getFirstName(), personIt.getLastName()).forEach(medicalRecordIt -> {
                    if (medicalRecordIt.getBirthdate() != null && !medicalRecordIt.getBirthdate().isEmpty()) {

                        personIt.setAge(medicalRecordIt.getBirthdate(), LocalDate.now());
                        if (personIt.getAge() <= 18) {
                            childrenList.add(personIt);
                        } else {
                            adultList.add(personIt);
                        }
                    }
                });
            });
        }catch (Exception exception) {
            logger.error("Error when we try to full children list and adult list :" + exception.getMessage());
        }
        //Implementation interface Map
        Map<String, List<Person>> mapImpl = new HashMap<String, List<Person>>();
        mapImpl.put("adultList", adultList);
        mapImpl.put("childrenList", childrenList);
        return mapImpl;
    }
}
