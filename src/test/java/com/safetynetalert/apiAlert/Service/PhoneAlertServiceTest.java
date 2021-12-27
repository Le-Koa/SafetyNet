package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.service.PhoneAlertService;
import com.safetynetalert.apiAlert.service.PhoneAlertServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class PhoneAlertServiceTest {

    @Autowired
   private PhoneAlertService phoneAlertService;

    @BeforeEach
    private void setUp(){

    }

    @Test
    public void testPhoneListFromPersonList(){

        Person person = new Person();
        person.setEmail("ilybnnr@gmail.com");
        person.setPhone("123-123-123");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        Person person1 = new Person();
        person1.setEmail("mobnnr@gmail.com");
        person1.setPhone("321-321-321");
        personList.add(person1);
        List<String> phoneList = new ArrayList<>();
        phoneList.add("123-123-123");
        phoneList.add("321-321-321");

        List<String> result = phoneAlertService.phoneListFromPersonList(personList);
        assertThat(result).isEqualTo(phoneList);
    }
}
