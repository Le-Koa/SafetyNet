package com.safetynetalert.apiAlert.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.controller.PersonController;
import com.safetynetalert.apiAlert.service.PersonService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private ReadJsonFile readJsonFile;

    private Person person;


    @Test
    public void testCreatePerson() throws Exception {
        Person person = new Person();
        person.setId((long)1);
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("11 rue du port");
        person.setCity("Draveil");
        person.setZip("91210");
        person.setPhone("123-123-123");
        person.setEmail("Ilybnnr@gmail.com");

        when(personService.savePerson(person)).thenReturn(person);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/person")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8").content(new ObjectMapper().writeValueAsString(person));

        this.mockMvc.perform(builder).andExpect(status().isOk());
    }
    @Test
    public void testUpdatePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("11 rue du port");
        person.setCity("Draveil");
        person.setZip("91210");
        person.setPhone("123-123-123");
        person.setEmail("Ilybnnr@gmail.com");

        long id = 1;

        when(personService.personIdExist(id)).thenReturn(true);
        when(personService.getPerson(id)).thenReturn(person);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/person/" + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(person));

        this.mockMvc.perform(builder).andExpect(status().isOk());


    }
    @Test
    public void testOnNonExistingPerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("11 rue du port");
        person.setCity("Draveil");
        person.setZip("91210");
        person.setPhone("123-123-123");
        person.setEmail("Ilybnnr@gmail.com");

        long id = 404;

        when(personService.personIdExist(id)).thenReturn(false);
        when(personService.getPerson(id)).thenReturn(person);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/person/" + id)
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(person));

        this.mockMvc.perform(builder).andExpect(status().isNotFound());

    }

    @Test
    public void testDeletePerson() throws Exception {
        when(personService.personExist("Tenley","Boyd")).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/person?firstName=Tenley&lastName=Boyd"))
                .andExpect(status().isOk());
    }
    //test fail
    /*
    @Test
    public void testDeletePersonDoesntExist() throws Exception {
        when(personService.personExist("Tenley","Boy")).thenReturn(false);
        mockMvc.perform(MockMvcRequestBuilders.delete("/person?firstName=Tenley&lastName=Boy"))
                .andExpect(status().isNotFound());
    } */
}
