package com.safetynetalert.apiAlert.Model;

import lombok.Data;


import java.util.List;

@Data
public class ChildAndAdultDTO {

    private List<ChildAlertDTO> childList;
    private  List<ChildAlertDTO> adultList;




    public ChildAndAdultDTO(List<ChildAlertDTO> childList, List<ChildAlertDTO> adultList) {
        this.childList = childList;
        this.adultList = adultList;
    }
}
