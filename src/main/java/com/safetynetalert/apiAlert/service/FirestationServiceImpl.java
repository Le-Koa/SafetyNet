package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FirestationServiceImpl implements FirestationService {
    private static final Logger logger = LogManager.getLogger(PersonServiceImpl.class);

    private final FirestationRepository firestationRepository;

    public FirestationServiceImpl(FirestationRepository firestationRepository) {
        this.firestationRepository = firestationRepository;
    }


    @Override
    public List<Firestation> findAll() {
        logger.warn("Method findAll , Class FirestationServiceImpl");
        return firestationRepository.findAll();
    }

    @Override
    public Firestation saveFirestation(Firestation firestation) {
        logger.warn("Method saveFirestation , Class FirestationServiceImpl");
        Firestation savedFirestation = firestationRepository.save(firestation);
        return savedFirestation;
    }

    @Override
    public Firestation getFirestation(String address, String station) {
        logger.warn("Method getFirestation , Class FirestationServiceImpl");
        Optional<Firestation> firestation = firestationRepository.findByAddressAndStation(address, station);
        if (firestation.isPresent()) {
            Firestation updatedFirestation = firestation.get();
            return updatedFirestation;
        } else {
            return null;
        }
    }

    @Override
    public Firestation getFirestationAddress(String address) {
        logger.warn("Method getFirestationAddress , Class FirestationServiceImpl");
        Optional<Firestation> firestation = firestationRepository.findByAddress(address);
        if (firestation.isPresent()){
            Firestation updatedFirestation = firestation.get();
            return  updatedFirestation;
        }
        return null;
    }

    @Override
    public Firestation getFirestationStation(String station) {
        logger.warn("Method getFirestationStation, Class FirestationServiceImpl");
        Optional<Firestation> firestation = firestationRepository.findByStation(station);
        if(firestation.isPresent()) {
            Firestation updatedFirestation = firestation.get();
            return  updatedFirestation;
        }
        return null;
    }

    @Override
    public void deleteFirestationByAddress(String address) {
        logger.warn("Method deleteFirestationByAddress , Class FirestationServiceImpl");
        firestationRepository.deleteByAddress(address);

    }

    @Override
    public void deleteFirestationByStation(String station) {
        logger.warn("Method deleteFirestationByStation , Class FirestationServiceImpl");
        firestationRepository.deleteByStation(station);

    }

    @Override
    public void deleteFirestationByStationAndAddress(String address, String station) {
        logger.warn("Method deleteFirestationByStationAndAddress , Class FirestationServiceImpl");
        firestationRepository.deleteByStationAndAddress(address, station);
    }

    @Override
    public List<String> getStationNumberList(List<Firestation> firestationList) {
        logger.warn("Method getStationNumberList , Class FirestationServiceImpl");
        List<String> firestationNumberList = new ArrayList<>();
        if(firestationList != null) {
            firestationList.forEach(firestationIt -> {
                if(firestationIt.getStation() != null) {
                    firestationNumberList.add(firestationIt.getStation());
                }
            } );
        }
        return firestationNumberList;
    }

    @Override
    public boolean firestationAddressAndStationNumberExist(String address, String station) {
        logger.warn("Method fireStationAddressAndStationNumberExist , Class FirestationServiceImpl");
        boolean existingAddressAndStationNumber = firestationRepository.existsByAddressAndStation(address , station);
        return existingAddressAndStationNumber;
    }


    @Override
    public List<String> firestationNumberListExist(List<String> stationNumberList) {
        logger.warn("Method fireStationNumberListExist  , Class FirestationServiceImpl");
        List<String> firestationNotFound = new ArrayList<>();
        stationNumberList.forEach(stationIt -> {
            if (!firestationRepository.existsByStation(stationIt)) {
                firestationNotFound.add(stationIt);
            }
        });
        return firestationNotFound;
    }


}
