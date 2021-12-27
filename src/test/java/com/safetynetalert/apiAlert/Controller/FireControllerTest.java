package com.safetynetalert.apiAlert.Controller;


import com.safetynetalert.apiAlert.controller.FireController;
import com.safetynetalert.apiAlert.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FireController.class)
public class FireControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonService personService;

    @MockBean
    private FireService fireService;

    @MockBean
    private ReadJsonFile readJsonFile;



    @Test
    public void testGetFire() throws Exception {
        String address = "29 15th St";
        when(personService.addressExist(address)).thenReturn(true);
        mockMvc.perform(get("/fire?address=" + address)).andExpect(status().isOk());
    }
}
