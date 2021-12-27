package com.safetynetalert.apiAlert.service;

import com.safetynetalert.apiAlert.Model.FireDTO;
import com.safetynetalert.apiAlert.Model.FloodFireDTO;
import com.safetynetalert.apiAlert.Model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FloodServiceImpl implements FloodService {
    private static final Logger logger = LogManager.getLogger(FloodServiceImpl.class);

    private final AddressService addressService;

    private final DTOService dtoService;

    public FloodServiceImpl(AddressService addressService, DTOService dtoService) {
        this.addressService = addressService;
        this.dtoService = dtoService;
    }


    @Override
    public List<FloodFireDTO> getInfoByAddress(List<String> stationNumberList) {
        logger.warn("Method getInfoByAddress , Class FloodServiceImpl");
        List<FloodFireDTO> personInfoByAddress = new ArrayList<>();
            List<String> addressList = addressService.addressListFromStationNumberList(stationNumberList);

            if (addressList != null) {
                addressList.forEach(addressIt -> {
                    List<Person> personList = addressService.getPersonListByAddress(addressIt);
                    List<FireDTO> fireDTOList = dtoService.FireDTO(personList);

                    FloodFireDTO floodFireDTO = new FloodFireDTO(fireDTOList, addressIt);
                    personInfoByAddress.add(floodFireDTO);


                });
            }
        return personInfoByAddress;
    }
}
