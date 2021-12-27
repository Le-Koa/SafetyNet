package com.safetynetalert.apiAlert.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.controller.MedicalRecordController;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import com.safetynetalert.apiAlert.service.medicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = MedicalRecordController.class)
public class MedicalRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private medicalRecordService medicalRecordService;

    @MockBean
    private ReadJsonFile readJsonFile;

    private MedicalRecord medicalRecord;

    @BeforeEach
    private void setUp() {
        medicalRecord = new MedicalRecord();
        medicalRecord.setLastName("Ilyass");
        medicalRecord.setFirstName("Bennour");
        medicalRecord.setBirthdate("29/04/1995");
        medicalRecord.setAllergies("Doliprane");
        medicalRecord.setMedications("Ameprazole");
    }

    @Test
    public void testDeleteMedicaleRecord() throws Exception {
        String firstName = "Jacob";
        String lastName = "Boyd";
        when(medicalRecordService.medicalRecordExist(firstName, lastName)).thenReturn(true);
        mockMvc.perform(MockMvcRequestBuilders.delete("/medicalRecord?firstName=Jacob&lastName=Boyd"))
                .andExpect(status().isOk());
    }

   @Test
    public void testUpdateMedicalRecord() throws Exception {
        long id = 1;
        when(medicalRecordService.getMedicalRecord(id)).thenReturn(medicalRecord);
       MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.put("/medicalRecord/" + id)
               .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
               .content(new ObjectMapper().writeValueAsString(medicalRecord));
       this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
   }

   @Test
    public void testCreateMedicalRecord() throws Exception {
        when(medicalRecordService.saveMedicalRecord(medicalRecord)).thenReturn(medicalRecord);
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.post("/medicalRecord")
                .contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON).characterEncoding("UTF-8")
                .content(new ObjectMapper().writeValueAsString(medicalRecord));
        this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
   }
}
