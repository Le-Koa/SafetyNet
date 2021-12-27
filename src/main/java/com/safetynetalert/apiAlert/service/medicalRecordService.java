package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.MedicalRecord;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface medicalRecordService {

 List<MedicalRecord> findAll();

 MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);

 MedicalRecord getMedicalRecord(Long id);

 void deleteMedicalRecord(String firstName, String lastName);

 boolean medicalRecordExist (String firstName, String lastName);
}
