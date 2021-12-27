package com.safetynetalert.apiAlert.Controller;

import com.safetynetalert.apiAlert.controller.PhoneAlertController;
import com.safetynetalert.apiAlert.service.FirestationService;
import com.safetynetalert.apiAlert.service.PhoneAlertService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PhoneAlertController.class)
public class PhoneAlertControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PhoneAlertService phoneAlertService;

    @MockBean
    private FirestationService firestationService;

    @MockBean
    private ReadJsonFile readJsonFile;

    @Test
    public void testPhoneAlert() throws Exception {
        when(firestationService.firestationAddressAndStationNumberExist("29 15th St","2"))
                .thenReturn(true);
        mockMvc.perform(get("/phoneAlert?firestation=3")).andExpect(status().isOk());
    }
}
