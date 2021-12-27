package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FirestationService {

     List<Firestation> findAll();

     Firestation saveFirestation(Firestation firestation);

     Firestation getFirestation(String address, String station);

     Firestation getFirestationAddress(String address);

     Firestation getFirestationStation(String station);

     void deleteFirestationByAddress(String address);

     void deleteFirestationByStation (String station);

     void deleteFirestationByStationAndAddress(String address, String station);

     List<String> getStationNumberList(List<Firestation> firestationList);

     boolean firestationAddressAndStationNumberExist(String address, String station);


     List<String> firestationNumberListExist(List<String> stationNumberList);


}
