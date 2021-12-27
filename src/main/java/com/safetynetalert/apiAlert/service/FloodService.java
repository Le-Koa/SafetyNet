package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.FloodFireDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FloodService {

     List<FloodFireDTO> getInfoByAddress(List<String> stationNumberList);

}
