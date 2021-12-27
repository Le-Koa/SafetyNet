package com.safetynetalert.apiAlert.Service;


import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import com.safetynetalert.apiAlert.service.medicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;


@SpringBootTest
public class MedicalrecordServiceTest {

    @Autowired
    private medicalRecordService medicalRecordService;

    @MockBean
    private MedicalRecordRepository medicalRecordRepositoryMock;

    private MedicalRecord medicalRecord;

    @BeforeEach
    private void setUp() {
         medicalRecord = new MedicalRecord();
    }


    @Test
    public void testDeleteMedicalRecord() {
        doNothing().when(medicalRecordRepositoryMock).deleteByFirstNameAndLastName("Ilyass", "Bennour");
        medicalRecordService.deleteMedicalRecord("Ilyass", "Bennour");
        verify(medicalRecordRepositoryMock, Mockito.times(1)).deleteByFirstNameAndLastName("Ilyass", "Bennour");
    }

    @Test
    public void testGetMedicalRecord() {
        long id  = 99;
        medicalRecord.setId(id);
        Optional<MedicalRecord> optionalMedicalRecord = Optional.of(medicalRecord);
        when(medicalRecordRepositoryMock.findById(id)).thenReturn(optionalMedicalRecord);
         MedicalRecord medicalRecord1 = medicalRecordService.getMedicalRecord(id);
         assertThat(medicalRecord1).isEqualTo(medicalRecord);

    }
    @Test
    public void testSaveMedicalRecord() {
        when(medicalRecordRepositoryMock.save(medicalRecord)).thenReturn(medicalRecord);

        MedicalRecord medicalRecord1 = medicalRecordService.saveMedicalRecord(medicalRecord);
        assertThat(medicalRecord1).isEqualTo(medicalRecord);
    }
    @Test
    public void testMedicalRecordExist() {
        String firstName = "Ilyass";
        String lastName = "Bennour";
        medicalRecord.setFirstName(firstName);
        medicalRecord.setLastName(lastName);

        when(medicalRecordRepositoryMock.existsByfirstNameAndLastName(firstName, lastName)).thenReturn(true);
        boolean result = medicalRecordService.medicalRecordExist(firstName, lastName);
        assertThat(result).isTrue();
    }
}

