package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class medicalRecordServiceImpl implements medicalRecordService {
    private static final Logger logger = LogManager.getLogger(medicalRecordServiceImpl.class);

    private final MedicalRecordRepository medicalRecordRepository;

    public medicalRecordServiceImpl(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }


    @Override
    public List<MedicalRecord> findAll() {
        logger.warn("Method findAll , Class medicalRecordServiceImpl ");
        return medicalRecordRepository.findAll();
    }

    @Override
    public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
        logger.warn("Method saveMedicalRecord , Class medicalRecordServiceImpl ");
        return medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord getMedicalRecord(Long id) {
        logger.warn("Method getMedicalRecord , Class medicalRecordServiceImpl ");
        Optional<MedicalRecord>medicalRecord = medicalRecordRepository.findById(id);
        if(medicalRecord.isPresent()) {
            MedicalRecord medRecord = medicalRecord.get();
            return medRecord;
        } else {
            return null;
        }
    }

    @Override
    public void deleteMedicalRecord(String firstName, String lastName) {
        logger.warn("Method deleteMedicalRecord , Class medicalRecordServiceImpl ");
        medicalRecordRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public boolean medicalRecordExist(String firstName, String lastName) {
        logger.warn("Method medicalRecordExist , Class medicalRecordServiceImpl ");
        boolean existMedRec = medicalRecordRepository.existsByfirstNameAndLastName(firstName, lastName);
        return existMedRec;
    }
}
