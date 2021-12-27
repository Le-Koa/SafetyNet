package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {
     List<String> addressListFromFirestationList(List<Firestation> firestationList);

     List<String> addressListFromStationNumberList(List<String> stationNumberList);

     void addAddressToListFromFirestation(List<Firestation> firestationList, List<String> addressList);

     List<Person> getPersonListByAddress(String address);
}
