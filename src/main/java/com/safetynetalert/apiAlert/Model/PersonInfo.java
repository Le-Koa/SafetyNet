package com.safetynetalert.apiAlert.Model;

import lombok.Data;

@Data
public class PersonInfo {

    private String lastName;

    private int age;

    private String address;

    private String city;

    private String zip;

    private String email;

    private String medications;

    private String allergies;



    public PersonInfo(String lastName, String address, String city, String zip, int age, String email, String allergies, String medications) {
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zip = zip;
        this.age = age;
        this.email = email;
        this.allergies = allergies;
        this.medications = medications;
    }
}
