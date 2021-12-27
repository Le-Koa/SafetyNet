package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import com.safetynetalert.apiAlert.service.PersonService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class PersonServiceTest {


    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;


    private Person person;

    @BeforeEach
    private void setUp() {

       person = new Person();
    }



    @Test
    public void testSavePerson() {
        when(personRepository.save(person)).thenReturn(person);

        Person person2 = personService.savePerson(person);
        assertThat(person2).isEqualTo(person);
    }
    @Test
    public void testDeletePerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(person);

        when(personRepository.findByFirstNameAndLastNameAllIgnoreCase("Ilyass", "Bennour")).thenReturn(personList);
        doNothing().when(personRepository).deletePersonByFirstNameAndLastNameAllIgnoreCase("Ilyass", "Bennour");

        personService.deletePerson("Ilyass", "Bennour");
        verify(personRepository,
                Mockito.times(1)).deletePersonByFirstNameAndLastNameAllIgnoreCase("Ilyass", "Bennour");
    }
    @Test
    public void testGetPerson() {
        long id = 70;
        person.setId(id);
        Optional<Person> optionalPerson = Optional.of(person);

        when(personRepository.findById(id)).thenReturn(optionalPerson);

        Person person2 = personService.getPerson(id);
        assertThat(person2).isEqualTo(person);
    }
    @Test
    public void testPersonExist () {
        String firstName = "Ilyass";
        String lastName = "Bennour";
        person.setFirstName(firstName);
        person.setLastName(lastName);

        when(personRepository.existsByfirstNameAndLastName(firstName, lastName)).thenReturn(true);
        boolean result = personService.personExist(firstName, lastName);
        assertThat(result).isTrue();
    }
    @Test
    public void testPersonIdExist(){
        long id = 99;
        person.setId(id);

        when(personRepository.existsById(id)).thenReturn(true);
        boolean result = personService.personIdExist(id);
        assertThat(result).isTrue();
    }
    @Test
    public void testCityExist(){
        String city = "Draveil";
        person.setCity(city);

        when(personRepository.existsByCity(city)).thenReturn(true);
        boolean result = personService.cityExist(city);
        assertThat(result).isTrue();
    }
    @Test
    public void testAddressExist() {
        String address  = "11 rue du port";
        person.setAddress(address);
        when(personRepository.existsByAddress(address)).thenReturn(true);
        boolean result= personService.addressExist(address);
        assertThat(result).isTrue();
    }
}
