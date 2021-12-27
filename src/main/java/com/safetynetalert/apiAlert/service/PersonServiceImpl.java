package com.safetynetalert.apiAlert.service;


import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@Component
public class PersonServiceImpl implements PersonService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    /*@Override
    public List<Person> findAll() {
        logger.warn("Method findAll , Class PersonServiceImpl");
        return personRepository.findAll();
    } */

    @Override
    public Person savePerson(Person person) {
        logger.warn("Method savePerson , Class PersonServiceImpl");
        return personRepository.save(person);
    }

    @Override
    public void deletePerson(String firstName, String lastName) {
        logger.warn("Method deletePerson , Class PersonServiceImpl");
        personRepository.deletePersonByFirstNameAndLastNameAllIgnoreCase(firstName, lastName);
    }

    @Override
    public Person findPerson(String firstName, String lastName) {
        logger.warn("Method findPerson , Class PersonServiceImpl");
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public Person getPerson(final Long id) {
        logger.warn("Method getPerson , Class PersonServiceImpl");
        Person person;
        Optional<Person> pers = personRepository.findById(id);
        if (pers.isPresent()) {
            person = pers.get();
        } else {
            return null;
        }
        return person;
    }

        @Override
        public boolean personExist (String firstName, String lastName){
            logger.warn("Method personExist , Class PersonServiceImpl");
            boolean existingPerson = personRepository.existsByfirstNameAndLastName(firstName, lastName);
            return existingPerson;
        }

    @Override
    public boolean personIdExist(Long id) {
        logger.warn("Method personIdExist , Class PersonServiceImpl");
        boolean existId = personRepository.existsById(id);
        return existId;
    }

    @Override
    public boolean cityExist(String city) {
        logger.warn("Method cityExist , Class PersonServiceImpl");
        boolean existingcity = personRepository.existsByCity(city);
        return existingcity;
    }

    @Override
    public boolean addressExist(String address) {
        logger.warn("Method addressExist , Class PersonServiceImpl");
        boolean existingaddress = personRepository.existsByAddress(address);
        return existingaddress;
    }


}
