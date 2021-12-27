package com.safetynetalert.apiAlert.Model;

import javax.persistence.*;

import lombok.*;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medical_records")

public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String birthdate;
    private String medications;
    private String allergies;

    public MedicalRecord(String firstName, String lastName, String birthdate, String medications, String allergies) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.medications = medications;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", medications='" + medications + '\'' +
                ", allergies='" + allergies + '\'' +
                '}';
    }






}