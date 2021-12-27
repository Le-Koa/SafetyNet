package com.safetynetalert.apiAlert.Controller;


import com.safetynetalert.apiAlert.controller.StationNumberController;
import com.safetynetalert.apiAlert.service.AddressFromStationNumberService;
import com.safetynetalert.apiAlert.service.FirestationService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import com.safetynetalert.apiAlert.service.StationNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = StationNumberController.class)
public class StationNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StationNumberService stationNumberService;

    @MockBean
    private FirestationService firestationService;

    @MockBean
    private AddressFromStationNumberService addressFromStationNumberService;

    @MockBean
    private ReadJsonFile readJsonFile;



    @Test
    public void testStationNumber() throws Exception {
    when(firestationService.firestationAddressAndStationNumberExist("644 Gershwin Cir","1"))
            .thenReturn(true);
    mockMvc.perform(get("/firestation?stationNumber=1"))
            .andExpect(status().isOk());
    }
}
