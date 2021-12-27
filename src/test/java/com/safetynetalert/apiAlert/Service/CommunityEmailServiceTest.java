package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import com.safetynetalert.apiAlert.service.CommunityEmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
public class CommunityEmailServiceTest {

    @Autowired
    private CommunityEmailService communityEmailService;

    @MockBean
    private PersonRepository personRepository;

    private Person person;
    private List<Person> personList;
    List<String> emailList;

    @BeforeEach
    private void setUp(){
        person = new Person();
        person.setEmail("Ilybnnr@gmail.com");
        personList = new ArrayList<>();
        personList.add(person);
        emailList = new ArrayList<>();
        emailList.add("Ilybnnr@gmail.com");
    }
    @Test
    public void testGetEmailFromPersonList(){
        List<String> stringList = communityEmailService.getEmailFromPersonList(personList);
        assertThat(stringList).isEqualTo(emailList);
    }

    @Test
    public void testGetEmailFromCity(){
        when(personRepository.findByCity("Draveil")).thenReturn(personList);

        List<String> stringList = communityEmailService.getEmailFromCity("Draveil");
        assertThat(stringList).isEqualTo(emailList);
    }
}
