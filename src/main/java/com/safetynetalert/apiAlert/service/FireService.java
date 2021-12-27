package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.Fire;
import org.springframework.stereotype.Service;

@Service
public interface FireService {

    Fire PersonListWithStationNumber (String address);
}
