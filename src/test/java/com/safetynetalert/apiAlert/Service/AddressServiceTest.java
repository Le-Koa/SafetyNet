package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.service.AddressService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AddressServiceTest {

    @Autowired
    private AddressService addressService;

    @MockBean
    private   FirestationRepository firestationRepository;

    @MockBean
    private Firestation firestation;

    private Firestation firestation1;

    private List<Firestation> firestationList;

    private List<String> stringList;

    @BeforeEach
    private void setUp(){
        firestation1 = new Firestation();
        firestation1.setId((long) 5);
        firestation1.setAddress("11 rue du port");
        firestation1.setStation("6");
        firestationList = new ArrayList<>();
        firestationList.add(firestation1);
        stringList = new ArrayList<>();
        stringList.add("11 rue du port");

    }

    @Test
    public void testAddressListFromStationNumberList(){
        List<String> stationNumberList = new ArrayList<>();
        stationNumberList.add("4");

        when(firestationRepository.findDistinctByStation("4")).thenReturn(firestationList);
        when(firestation.getAddress()).thenReturn("11 rue du port");

        List<String> stringList1 = addressService.addressListFromStationNumberList(stationNumberList);
        assertThat(stringList1).isEqualTo(stringList);
    }

    @Test
    public void testAddressListFromFirestationList(){
        Firestation firestation2 = new Firestation();
        firestation2.setAddress("12 rue du port");
        firestation2.setStation("5");
        firestationList.add(firestation2);
        stringList.add("12 rue du port");

        List<String> result = addressService.addressListFromFirestationList(firestationList);
        assertThat(result).isEqualTo(stringList);
    }
    @Test
    public void testAddAddressToListFromFirestation(){
        List<String> listAddress = new ArrayList<>();
        Firestation firestation2 = new Firestation();
        firestation2.setStation("10");
        firestation2.setAddress("13 rue du port");
        firestationList.add(firestation2);
        stringList.add("13 rue du port");

        addressService.addAddressToListFromFirestation(firestationList, listAddress);
        assertThat(listAddress).isEqualTo(stringList);
    }
}
