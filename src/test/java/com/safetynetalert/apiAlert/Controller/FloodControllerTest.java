package com.safetynetalert.apiAlert.Controller;

import com.safetynetalert.apiAlert.controller.FloodController;
import com.safetynetalert.apiAlert.service.FirestationService;
import com.safetynetalert.apiAlert.service.FloodService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FloodController.class)
public class FloodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationService firestationService;

    @MockBean
    private FloodService floodService;

    @MockBean
    private ReadJsonFile readJsonFile;

    @Test
    public void testFloodFromStation() throws Exception {
       List<String> firestationNumberList = new ArrayList<>();
       firestationNumberList.add("1");
       firestationNumberList.add("3");

        List<String> emptyFirestationList = new ArrayList<>();
        when(firestationService.firestationNumberListExist(firestationNumberList))
                .thenReturn(emptyFirestationList);
        mockMvc.perform(get("/flood?stations=1,3")).andExpect(status().isOk());
    }
}
