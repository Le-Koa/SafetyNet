package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{
    private static final Logger logger = LogManager.getLogger(AddressServiceImpl.class);

    private final FirestationRepository firestationRepository;

    private final PersonInfoService personInfoService;

    private final PersonRepository personRepository;

    public AddressServiceImpl(FirestationRepository firestationRepository, PersonInfoService personInfoService, PersonRepository personRepository) {
        this.firestationRepository = firestationRepository;
        this.personInfoService = personInfoService;
        this.personRepository = personRepository;
    }


    @Override
    public List<String> addressListFromFirestationList(List<Firestation> firestationList) {
        logger.warn("Method addressListFromFirestationList , Class AddressServiceImpl");
        List<String> addressList = new ArrayList<>();
        if (firestationList != null) {
            firestationList.forEach(firestationIt -> {
                if (firestationIt.getAddress() != null && !firestationIt.getAddress().isEmpty()) {
                    addressList.add(firestationIt.getAddress());
                }
            } );
        }
        return addressList;
    }

    @Override
    public List<String> addressListFromStationNumberList(List<String> stationNumberList) {
        logger.warn("Method addressListFromStationNumberList , Class AddressServiceImpl");
        List<String> addressList = new ArrayList<>();
        if (stationNumberList != null) {
            stationNumberList.forEach(stationNumberIt -> addAddressToListFromFirestation(firestationRepository.findDistinctByStation(stationNumberIt), addressList));
        }
        return addressList;
    }

    @Override
    public void addAddressToListFromFirestation(List<Firestation> firestationList, List<String> addressList) {
        logger.warn("Method addAddressToListFromFirestation , Class AddressServiceImpl");
        firestationList.forEach(firestationIt -> {
            if(firestationIt.getAddress() != null && !firestationIt.getAddress().isEmpty()) {
                addressList.add(firestationIt.getAddress());
            }
        } );

    }

    @Override
    public List<Person> getPersonListByAddress(String address) {
        logger.warn("Method getPersonListByAddress , Class AddressServiceImpl");
        List<Person> personList = null;

        personList = personRepository.findDistinctByAddress(address);
        personInfoService.setAgeAndMedicationsAndAllergies(personList, LocalDate.now());
        return personList;
    }
}
