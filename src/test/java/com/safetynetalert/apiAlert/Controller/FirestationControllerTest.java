package com.safetynetalert.apiAlert.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.controller.FirestationController;
import com.safetynetalert.apiAlert.service.FirestationService;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = FirestationController.class)
public class FirestationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FirestationService firestationService;

    @MockBean
    private ReadJsonFile readJsonFile;

    private Firestation firestation;

    @BeforeEach
    private void setUp(){
        firestation = new Firestation();
        firestation.setStation("4");
        firestation.setAddress("11 rue du port");
    }

    @Test
    public void testAddFirestation() throws Exception {
        when(firestationService.saveFirestation(firestation)).thenReturn(firestation);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/firestation")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(firestation));
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testUpdateFirestation() throws Exception {
        String station = "9";
        String address = "12 rue du port";

        when(firestationService.getFirestation(address, station)).thenReturn(firestation);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/firestation?address=" + address + "&station=" + station.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(firestation));
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
    }
   /* @Test
    public void testUpdateFirestationDoesntExist() throws Exception {
        String station = "9";
        String address = "12 rue du port";

      when(firestationService.getFirestation(address, station)).thenReturn(null);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
                .put("/firestation?address=" + address + "&station=" + station.toString())
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(firestation));
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isNotFound());

    }*/

    @Test
    public void testDeleteFirestation() throws Exception {
        String station = "2";
        String address = "29 15th St";

        when(firestationService.firestationAddressAndStationNumberExist(station, address)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/firestation?address=" + address + "&station=" + station.toString()))
                .andExpect(status().isOk());
    }

}
