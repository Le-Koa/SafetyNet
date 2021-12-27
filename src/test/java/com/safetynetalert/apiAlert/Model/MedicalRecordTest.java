package com.safetynetalert.apiAlert.Model;


import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class MedicalRecordTest {

    private MedicalRecord medicalRecord;



    @MockBean
    private ReadJsonFile readJsonFile;

    private long id;
    private String firstName;
    private String lastName;
    private String birthdate;
    private String medications;
    private String allergies;

    @BeforeEach
    private void setUp() {

        medicalRecord = new MedicalRecord();
        medicalRecord.setId((long)99);
    }


    @Test
    public void testGetFirstName() throws Exception {
        medicalRecord.setFirstName("Leech");
        assertEquals("Leech", medicalRecord.getFirstName());
    }
    @Test
    public void testGetLastName() throws Exception {
        medicalRecord.setLastName("ing");
        assertEquals("ing", medicalRecord.getLastName());
    }
    @Test
    public void testGetBirthdate() throws Exception {
        medicalRecord.setBirthdate("11/11/2011");
        assertEquals("11/11/2011", medicalRecord.getBirthdate());
    }
    @Test
    public void testGetMedication() throws Exception {
        medicalRecord.setMedications("Omeprazol");
        assertEquals("Omeprazol", medicalRecord.getMedications());
    }
    @Test
    public void testGetAllergies() throws Exception {
        medicalRecord.setAllergies("Ligma");
        assertEquals("Ligma", medicalRecord.getAllergies() );
    }

    @Test
    public void testToString() {
        String expected = "MedicalRecord{" +
                "id=" + medicalRecord.getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", medications='" + medications + '\'' +
                ", allergies='" + allergies + '\'' +
                '}';

        Assert.assertEquals(expected, medicalRecord.toString());
    }
}
