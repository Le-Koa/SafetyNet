package com.safetynetalert.apiAlert.service;




import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;
import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;


@Service
@Data
public class ReadJsonFile {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private FirestationRepository fireStationRepository;
    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    public ReadJsonFile() throws IOException {
    }

    String filePath = "src/main/resources/json/data.json";
    byte[] bytesFile = Files.readAllBytes(new File(filePath).toPath());
    JsonIterator iter = JsonIterator.parse(bytesFile);
    Any any = iter.readAny();


    public List<Person> personsList() {

        Any personAny = any.get("persons");
        List<Person> persons = new ArrayList<>();
        for (Any person : personAny) {
            persons.add(new Person(
                    person.get("firstName").toString(),
                    person.get("address").toString(),
                    person.get("city").toString(),
                    person.get("lastName").toString(),
                    person.get("phone").toString(),
                    person.get("zip").toString(),
                    person.get("age").toInt(),
                    person.get("email").toString()));

        }
        return persons;


    }

    public List<Firestation> firestationList() {
        Any firestationAny = any.get("firestations");
        List<Firestation> firestations = new ArrayList<>();
        for (Any firestation : firestationAny) {
            firestations.add(new Firestation(
                    firestation.get("address").toString(),
                    firestation.get("station").toString()));
        }
        return firestations;
    }

    public List<MedicalRecord> medicalRecordList() {
        Any medicalRecordAny = any.get("medicalrecords");
        List<MedicalRecord> medicalRecords = new ArrayList<>();
        for (Any medicalrecord : medicalRecordAny) {
            medicalRecords.add(new MedicalRecord(
                    medicalrecord.get("firstName").toString(),
                    medicalrecord.get("lastName").toString(),
                    medicalrecord.get("birthdate").toString(),
                    medicalrecord.get("medications").toString(),
                    medicalrecord.get("allergies").toString()));
        }
        return medicalRecords;
    }

    public void saveInDb() throws IOException {


        personRepository.saveAll(personsList());
        fireStationRepository.saveAll(firestationList());
        medicalRecordRepository.saveAll(medicalRecordList());
    }
}