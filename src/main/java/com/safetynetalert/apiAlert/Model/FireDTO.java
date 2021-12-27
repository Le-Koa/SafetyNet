package com.safetynetalert.apiAlert.Model;

import lombok.Data;



@Data
public class FireDTO {

    private String lastName;

    private int age;

    private String address;

    private String phone;

    private String medications;

    private String allergies;

    public FireDTO(String lastName, int age, String phone, String medications, String allergies) {
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
        this.medications = medications;
        this.allergies = allergies;
    }
}
