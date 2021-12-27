package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneAlertServiceImpl implements PhoneAlertService {

    private static final Logger logger = LogManager.getLogger(PhoneAlertServiceImpl.class);

    private final PersonRepository personRepository;

    private final FirestationRepository firestationRepository;

    private final AddressService addressService;

    public PhoneAlertServiceImpl(PersonRepository personRepository, FirestationRepository firestationRepository, AddressService addressService) {
        this.personRepository = personRepository;
        this.firestationRepository = firestationRepository;
        this.addressService = addressService;
    }

    @Override
    public List<String> phoneListFromPersonList(List<Person> personList) {
        logger.warn("Method phoneListFromPersonList ,Class PhoneAlertServiceImpl ");
        List<String> phoneList = new ArrayList<>();
        if (personList != null) {
            personList.forEach(personIt -> {
                if (personIt.getPhone() != null && !personIt.getPhone().isEmpty()) {
                    phoneList.add(personIt.getPhone());
                }
            } );
        }
        return phoneList;
    }

    @Override
    public List<String> PhoneNumberListFromFirestation( String firestation) {
        logger.warn("Method PhoneNumberListFromFirestation ,Class PhoneAlertServiceImpl ");
        List<Firestation> firestationList = firestationRepository.findDistinctByStation(firestation);
        List<String> addressList =addressService.addressListFromFirestationList(firestationList);
        List<Person> personList = personRepository.findAllByAddressInOrderByAddress(addressList);
        List<String> phoneList = phoneListFromPersonList(personList);
        return phoneList;
    }
}
