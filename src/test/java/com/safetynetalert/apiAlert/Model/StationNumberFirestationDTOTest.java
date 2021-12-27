package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class StationNumberFirestationDTOTest {


    private StationNumberFirestationDTO stationNumberFirestationDTO;
    List<StationNumberFirestation> stationNumberFirestationList;
    private int numberOfChildren;
    private int numberOfAdult;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {

        StationNumberFirestation stationNumberFirestation = new StationNumberFirestation(
                "Ilyass",
                "Bennour",
                "20 rue du port",
                "91210",
                "123-123",
                "juvisy");
        StationNumberFirestation stationNumberFirestation1 = new StationNumberFirestation(
                "Mayd",
                "So",
                "ttvland",
                "91650",
                "1234-1234",
                "draveil"
        );
        stationNumberFirestationList = new ArrayList<>();
        stationNumberFirestationList.add(stationNumberFirestation);
        stationNumberFirestationList.add(stationNumberFirestation1);
        numberOfChildren = 10;
        numberOfAdult = 8;
        stationNumberFirestationDTO = new StationNumberFirestationDTO(stationNumberFirestationList, numberOfAdult, numberOfChildren);
    }

    @Test
    public void testGetPersonList() throws Exception {
        assertEquals(stationNumberFirestationList, stationNumberFirestationDTO.getPersonList());
    }

    @Test
    public void testGetNumberOfAdult() throws Exception {
        assertEquals(numberOfAdult, stationNumberFirestationDTO.getNumberOfAdult());
    }

    @Test
    public void testGetNumberOfChildren() throws Exception {
        assertEquals(numberOfChildren, stationNumberFirestationDTO.getGetNumberOfChildren());
    }

    @Test
    public void simpleEqualsHome() {
        EqualsVerifier.simple().forClass(StationNumberFirestationDTO.class).verify();
    }
    @Test
    public void testToString() {
        String expected = "StationNumberFirestationDTO(personList=" + stationNumberFirestationList + ", numberOfAdult="
                + numberOfAdult
                + ", getNumberOfChildren=" + numberOfChildren + ")";
        Assert.assertEquals(expected, stationNumberFirestationDTO.toString());
    }
}
