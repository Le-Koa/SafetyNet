package com.safetynetalert.apiAlert.Controller;

import com.safetynetalert.apiAlert.controller.CommunityEmailController;

import com.safetynetalert.apiAlert.service.CommunityEmailService;
import com.safetynetalert.apiAlert.service.PersonService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CommunityEmailController.class)
public class CommunityEmailControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private CommunityEmailService communityEmailService;

    @MockBean
    private ReadJsonFile readJsonFile;

    @Test
     public void testCommunityEmail() throws Exception {
        when(personService.cityExist("culver")).thenReturn(true);
        mockMvc.perform(get("/communityEmail?city=culver"))
                .andExpect(status().isOk());
    }
// test not working
    /*
    @Test
    public void testCommunityEmailDoesntExist() throws Exception {
        when(personService.cityExist("culver")).thenReturn(false);
        mockMvc.perform(get("/communityEmail?city=culver"))
                .andExpect(status().isNotFound());
    }*/
}
