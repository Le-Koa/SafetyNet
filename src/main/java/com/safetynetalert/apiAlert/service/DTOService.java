package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DTOService {

    public List<ChildAlertDTO>ChildAlertDTO(List<Person> personList){
        List<ChildAlertDTO> childAlertDTOList = new ArrayList<>();
        personList.forEach(personIt -> {
            ChildAlertDTO childAlertDTO = new ChildAlertDTO(personIt.getAge(), personIt.getLastName(),
                    personIt.getFirstName());
            childAlertDTOList.add(childAlertDTO);
        });
        return childAlertDTOList;
    }

    public List<StationNumberFirestation>StationNumberDTO(List<Person> personList) {
        List<StationNumberFirestation> stationNumberFirestationList = new ArrayList<>();
        personList.forEach(personIt -> {
            StationNumberFirestation stationNumberFirestation = new StationNumberFirestation(personIt.getFirstName(),
                    personIt.getLastName(),
                    personIt.getAddress(),
                    personIt.getZip(),
                    personIt.getPhone(),
                    personIt.getCity());
            stationNumberFirestationList.add(stationNumberFirestation);
        });
        return stationNumberFirestationList;
    }
    public List<FireDTO>FireDTO(List<Person> personList) {
        List<FireDTO> fireDTOList = new ArrayList<>();
        personList.forEach(personIt -> {
            FireDTO fireDTO = new FireDTO(personIt.getLastName(), personIt.getAge(), personIt.getPhone(), personIt.getAllergies(),
                    personIt.getMedications());
            fireDTOList.add(fireDTO);
        } );
        return fireDTOList;
    }

    public List<PersonInfo> PersonInfoDTO(List<Person> personList) {
        List<PersonInfo> personInfoList = new ArrayList<>();
        personList.forEach(personIt ->{
            PersonInfo personInfo = new PersonInfo(personIt.getLastName(),personIt.getAddress(),personIt.getCity(),personIt.getZip(),
                    personIt.getAge(),personIt.getEmail(),personIt.getAllergies(),personIt.getMedications());
            personInfoList.add(personInfo);
        } );
        return personInfoList;
    }
}
