package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Fire;
import com.safetynetalert.apiAlert.Model.FireDTO;
import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;

import java.util.List;


@Service
public class FireServiceImpl implements FireService {

    private static final Logger logger = LogManager.getLogger(FirestationServiceImpl.class);

    private final AddressService addressService;

    private final DTOService dtoService;

    private final FirestationService firestationService;

    private final FirestationRepository firestationRepository;

    public FireServiceImpl(AddressService addressService, DTOService dtoService, FirestationService firestationService, FirestationRepository firestationRepository) {
        this.addressService = addressService;
        this.dtoService = dtoService;
        this.firestationService = firestationService;
        this.firestationRepository = firestationRepository;
    }

    @Override
    public Fire PersonListWithStationNumber(String address) {
        logger.warn("Method PersonListWithStationNumber, Class FireServiceImpl");
        Fire fire = null;
        List<Person> personList = addressService.getPersonListByAddress(address);
        List<Firestation> firestationList = firestationRepository.findDistinctByAddress(address);
        List<String> stationNumberList = firestationService.getStationNumberList(firestationList);
        List<FireDTO> fireDTOList = dtoService.FireDTO(personList);
        //Object personList + address firestation
        fire = new Fire(fireDTOList, stationNumberList);
        return fire;
    }
}
