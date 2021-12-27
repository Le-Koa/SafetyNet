package com.safetynetalert.apiAlert.controller;

import com.safetynetalert.apiAlert.Model.MedicalRecord;

import com.safetynetalert.apiAlert.service.medicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordController {
    private static final Logger logger = LogManager.getLogger(MedicalRecordController.class);

  private final medicalRecordService medicalRecordService;

    public MedicalRecordController(medicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    @GetMapping("/medicalRecord")
    public List<MedicalRecord> findAll(){
        logger.info("Request the full list of medicalRecord to a endpoint");
        return medicalRecordService.findAll();
    }

    @PostMapping("/medicalRecord")
    public MedicalRecord createMedicalRecord(@RequestBody MedicalRecord medicalRecord){
        logger.info("Request to create and save a medecial record to a endpoint", medicalRecord);
        return medicalRecordService.saveMedicalRecord(medicalRecord);
    }
    @PutMapping("/medicalRecord/{id}")
    public MedicalRecord updateMedicalRecord(@PathVariable("id") Long id, @RequestBody MedicalRecord medicalRecord){
        MedicalRecord medRecoUpdate;
        medRecoUpdate = medicalRecordService.getMedicalRecord(id);
        logger.info("Request to update a current medicalRecord to a endpoint", medicalRecord);
        if (medRecoUpdate != null){
            String birthdate = medicalRecord.getBirthdate();
            if(birthdate != null)
                medRecoUpdate.setBirthdate(birthdate);
        }
        String medications = medicalRecord.getMedications();
        if (medications != null) {
            medicalRecord.setMedications(medications);
        }
        String allergies = medicalRecord.getAllergies();
        if (allergies != null){
            medRecoUpdate.setAllergies(allergies);
        }
        medicalRecordService.saveMedicalRecord(medRecoUpdate);
        return medRecoUpdate;
    }
    @Transactional
    @DeleteMapping("/medicalRecord")
    public void deleteMedicalRecord (@RequestParam String lastName, @RequestParam String firstName){
        boolean existMedRec;
            logger.info("Request to delete a existing medicalRecord to a endpoint", lastName , firstName);
            existMedRec = medicalRecordService.medicalRecordExist(lastName, firstName);
            if(existMedRec){
                medicalRecordService.deleteMedicalRecord(lastName, firstName);
            }



    }
}
