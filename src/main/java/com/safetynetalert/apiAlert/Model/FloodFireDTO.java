package com.safetynetalert.apiAlert.Model;

import lombok.Data;

import java.util.List;

@Data
public class FloodFireDTO {

    private List<FireDTO> personList;

    private String address;


    public FloodFireDTO(List<FireDTO> personList, String address) {
        this.personList = personList;
        this.address = address;
    }


}
