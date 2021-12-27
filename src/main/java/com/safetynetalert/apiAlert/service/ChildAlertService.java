package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.ChildAndAdultDTO;
import org.springframework.stereotype.Service;

@Service
public interface ChildAlertService {

    ChildAndAdultDTO adultAndChildrenList(String address);
}
