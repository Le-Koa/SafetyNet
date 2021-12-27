package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.service.FirestationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

import static org.mockito.Mockito.*;

@SpringBootTest
public class FirestationServiceTest {

    @Autowired
    private FirestationService firestationService;
    @MockBean
    private FirestationRepository firestationRepositoryMock;

    private Firestation firestation;

    @BeforeEach
    private void setUp() {
        firestation = new Firestation();
    }

    @Test
    public void testGetFireStation() {
        String address = "20 rue de la treille";
        firestation.setAddress(address);
        Optional<Firestation> optionalFireStation = Optional.of(firestation);

        when(firestationRepositoryMock.findByAddress(address)).thenReturn(optionalFireStation);

        Firestation fireStationResult = firestationService.getFirestationAddress(address);
        assertThat(fireStationResult).isEqualTo(firestation);
    }
    @Test
    public void testGetFirestationStation(){
        String station = "10";
        firestation.setStation(station);
        Optional<Firestation> optionalFirestation = Optional.of(firestation);

        when(firestationRepositoryMock.findByStation(station)).thenReturn(optionalFirestation);

        Firestation firestationResult1 = firestationService.getFirestationStation(station);
        assertThat(firestationResult1).isEqualTo(firestation);
    }

    @Test
    public void testGetStationNumberList(){
        Firestation firestation = new Firestation();
        firestation.setStation("8");
        firestation.setAddress("11 rue du port");
        firestation.setId((long)21);
        Firestation firestation1 = new Firestation();
        firestation1.setStation("12");
        firestation1.setAddress("12 rue du port");
        firestation1.setId((long)12);
        List<Firestation> firestationList = new ArrayList<>();
        firestationList.add(firestation);
        firestationList.add(firestation1);
        List<String> stationNumberList = new ArrayList<>();
        stationNumberList.add("8");
        stationNumberList.add("12");

        List<String> result = firestationService.getStationNumberList(firestationList);
        assertThat(result).isEqualTo(stationNumberList);
    }
    @Test
    public void testSaveFirestation(){
       when(firestationRepositoryMock.save(firestation)).thenReturn(firestation);
       Firestation firestation1 = firestationService.saveFirestation(firestation);
       assertThat(firestation1).isEqualTo(firestation);

    }
    @Test
    public void testGetFirestation(){
        String station = "10";
        String address = "11 rue du port";
        firestation.setStation(station);
        firestation.setAddress(address);
        Optional<Firestation> optionalFirestation = Optional.of(firestation);

        when(firestationRepositoryMock.findByAddressAndStation(address, station)).thenReturn(optionalFirestation);

        Firestation firestation1 = firestationService.getFirestation(address,station);
        assertThat(firestation1).isEqualTo(firestation);
    }

    @Test
    public void testGetFirestationAddress(){
        String address = "11 rue du port";
        firestation.setAddress(address);
        Optional<Firestation>optionalFirestation = Optional.of(firestation);

        when(firestationRepositoryMock.findByAddress(address)).thenReturn(optionalFirestation);

        Firestation firestation1 = firestationService.getFirestationAddress(address);
        assertThat(firestation1).isEqualTo(firestation);

    }

    @Test
    public void testGetFirestationNumberListExist() {
        List<String> stringList = new ArrayList<>();
        stringList.add("10");
        List<String> stringListNotFound = new ArrayList<>();
         when(firestationRepositoryMock.existsByStation("10")).thenReturn(true);

         List<String> result = firestationService.firestationNumberListExist(stringList);
         assertThat(result).isEqualTo(stringListNotFound);
    }

    @Test
    public void testGetFirestationAddressAndStationNumberExist() {
        String station = "10";
        String address = "11 rue du port";
        firestation.setStation(station);
        firestation.setAddress(address);

        when(firestationRepositoryMock.existsByAddressAndStation(address, station)).thenReturn(true);
        boolean result = firestationService.firestationAddressAndStationNumberExist(address,station);
        assertThat(result).isTrue();
    }
    @Test
    public void testDeleteFirestationByStationAndAddress(){
        List<Firestation> firestationList = new ArrayList<>();
        firestationList.add(firestation);
        Optional<Firestation> optionalFirestation = Optional.of(firestation);

       when(firestationRepositoryMock.findByAddressAndStation("11 rue du port","10" ))
               .thenReturn(optionalFirestation);
       doNothing().when(firestationRepositoryMock).deleteByStationAndAddress("11 rue du port","10");

       firestationService.deleteFirestationByStationAndAddress("11 rue du port","10");
       verify(firestationRepositoryMock, Mockito.times(1))
               .deleteByStationAndAddress("11 rue du port","10");
    }
}
