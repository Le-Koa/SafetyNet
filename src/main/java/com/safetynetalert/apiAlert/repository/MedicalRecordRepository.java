package com.safetynetalert.apiAlert.repository;

import com.safetynetalert.apiAlert.Model.MedicalRecord;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord,Long> {


    List<MedicalRecord>findAll();

    List<MedicalRecord> findByFirstNameAndLastName(String firstName, String lastName);

    void deleteByFirstNameAndLastName(String firstName, String lastName);

    boolean existsByfirstNameAndLastName(String firstName, String lastName);



}
