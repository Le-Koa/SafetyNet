package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.StationNumberFirestationDTO;
import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StationNumberService {

    StationNumberFirestationDTO getPersonsDetailsFromStationNumber(String stationNumber);

    List<Person> getPersonListFromStationNumber(String stationNumber);
}
