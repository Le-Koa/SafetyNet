package com.safetynetalert.apiAlert.Model;

import lombok.Data;

@Data
public class StationNumberFirestation {

    private String firstName;
    private String lastName;
    private String address;
    private String zip;
    private String phone;
    private String city;


    public StationNumberFirestation(String firstName, String lastName, String address, String zip, String phone, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.zip = zip;
        this.phone = phone;
        this.city = city;
    }

}
