package com.safetynetalert.apiAlert.Model;

import lombok.Data;

import java.util.List;

@Data
public class StationNumberFirestationDTO {

    private List<StationNumberFirestation> personList;
    private int numberOfAdult;
    private int getNumberOfChildren;

    public StationNumberFirestationDTO(List<StationNumberFirestation> personList, int numberOfAdult, int getNumberOfChildren) {
        this.personList = personList;
        this.numberOfAdult = numberOfAdult;
        this.getNumberOfChildren = getNumberOfChildren;
    }

}
