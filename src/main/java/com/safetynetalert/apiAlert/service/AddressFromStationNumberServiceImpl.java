package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressFromStationNumberServiceImpl implements AddressFromStationNumberService {
    private static final Logger logger = LogManager.getLogger(AddressFromStationNumberServiceImpl.class);


    @Override
    public List<String> getAddressFromFirestationList(List<Firestation> firestationList) {
        logger.warn("Method AddressFromStationNumberServiceImpl , Class AddressFromStationNumberServiceImpl");
        List<String> addressList = new ArrayList<>();
        if(firestationList != null){
            firestationList.forEach(firestationIt -> {
                //&& verifie 1er operande ensuite la 2iem
                if( firestationIt.getAddress() != null && !firestationIt.getAddress().isEmpty()){
                    addressList.add(firestationIt.getAddress());
                }
            });
        }
        return addressList;
    }
}
