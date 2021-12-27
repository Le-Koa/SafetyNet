package com.safetynetalert.apiAlert.Model;

import lombok.Data;

import java.util.List;

@Data
public class Fire {

    private List<FireDTO> personList;
    private List<String> firestationNumberList;

    public Fire(List<FireDTO> personList, List<String> firestationNumberList) {
        this.personList = personList;
        this.firestationNumberList = firestationNumberList;
    }
}
