package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.StationNumberFirestationDTO;
import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.StationNumberFirestation;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class StationNumberServiceImpl implements StationNumberService {
    private static final Logger logger = LogManager.getLogger(StationNumberServiceImpl.class);

    private final DTOService dtoService;

    private final FirestationRepository firestationRepository;

    private final PersonRepository personRepository;

    private final AddressFromStationNumberService addressFromStationNumberService;

    private final AdultOrChildrenService adultOrChildrenService;

    public StationNumberServiceImpl(DTOService dtoService, FirestationRepository firestationRepository, PersonRepository personRepository, AddressFromStationNumberService addressFromStationNumberService, AdultOrChildrenService adultOrChildrenService) {
        this.dtoService = dtoService;
        this.firestationRepository = firestationRepository;
        this.personRepository = personRepository;
        this.addressFromStationNumberService = addressFromStationNumberService;
        this.adultOrChildrenService = adultOrChildrenService;
    }


    @Override
    public StationNumberFirestationDTO getPersonsDetailsFromStationNumber(String stationNumber) {
        logger.warn("Method getPersonsDetailsFromStationNumber, Class StationNumberServiceImpl");
        StationNumberFirestationDTO stationNumberFirestationDTO = null;
        if (stationNumber != null) {
            List<Person> filterPersonList = getPersonListFromStationNumber(stationNumber);
            List<Person> childrenList = new ArrayList<>();
            List<Person> adultList = new ArrayList<>();
            Map<String, List<Person>> map = adultOrChildrenService.listOfAllAdultAndChildren(childrenList, adultList,filterPersonList);
            List<Person> childrenList1 = map.get("childrenList");
            List<Person> adultList1 = map.get("adultList");

            int child = childrenList1.size();
            int adult = adultList1.size();

            List<StationNumberFirestation> stationNumberFirestationList = dtoService.StationNumberDTO(filterPersonList);
            stationNumberFirestationDTO = new StationNumberFirestationDTO(stationNumberFirestationList, child, adult);

        } else {
            return null;
        }
        return stationNumberFirestationDTO;
    }


    @Override
    public List<Person> getPersonListFromStationNumber(String stationNumber) {
        logger.warn("Method getPersonListFromStationNumber, Class StationNumberServiceImpl");
        List<Person> filterPersonList = null;

        List<Firestation> firestationList = firestationRepository.findDistinctByStation(stationNumber);
        List<String> addressList = addressFromStationNumberService.getAddressFromFirestationList(firestationList);
        filterPersonList = personRepository.findAllByAddressInOrderByAddress(addressList);


        return filterPersonList;
    }


}
