package com.safetynetalert.apiAlert.Controller;


import com.safetynetalert.apiAlert.controller.ChildAlertController;
import com.safetynetalert.apiAlert.service.ChildAlertService;
import com.safetynetalert.apiAlert.service.PersonService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ChildAlertController.class)
public class ChildAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private ChildAlertService childAlertService;

    @MockBean
    private ReadJsonFile readJsonFile;

    @Test
    public void testgetFilter() throws Exception {
        String address = "29 15th St";
        when(personService.addressExist(address)).thenReturn(true);
        mockMvc.perform(get("/childAlert?address=" + address)).andExpect(status().isOk());
    }
}
