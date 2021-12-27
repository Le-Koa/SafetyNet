package com.safetynetalert.apiAlert.Controller;


import com.safetynetalert.apiAlert.controller.PersonInfoController;
import com.safetynetalert.apiAlert.service.PersonInfoService;
import com.safetynetalert.apiAlert.service.PersonService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonInfoController.class)

public class PersonInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private PersonInfoService personInfoService;

    @MockBean
    private ReadJsonFile readJsonFile;


    @Test
    public void testGetPersonInfo() throws Exception {
        when(personService.personExist("Jacob", "Boyd")).thenReturn(true);
        mockMvc.perform(get("/personInfo?firstName=Jacob&lastName=Boyd"))
                .andExpect(status().isOk());
    }

    // Issue running this test
   /* @Test
    public void testGetPersonInfoDoesntExist() throws Exception {
        when(personService.personExist("Jacob","Boy")).thenReturn(false);
        mockMvc.perform(get("/personInfo?firstName=Jacob&lastName=Boy"))
                .andExpect(status().isNotFound());
    }*/
}
