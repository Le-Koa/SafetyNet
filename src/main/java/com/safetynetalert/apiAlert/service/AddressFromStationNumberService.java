package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressFromStationNumberService {

    List<String> getAddressFromFirestationList(List<Firestation> firestationList);
}
