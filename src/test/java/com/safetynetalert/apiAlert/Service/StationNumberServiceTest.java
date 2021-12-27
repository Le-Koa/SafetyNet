package com.safetynetalert.apiAlert.Service;


import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.StationNumberFirestation;
import com.safetynetalert.apiAlert.Model.StationNumberFirestationDTO;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import com.safetynetalert.apiAlert.service.AddressService;
import com.safetynetalert.apiAlert.service.AdultOrChildrenService;
import com.safetynetalert.apiAlert.service.DTOService;
import com.safetynetalert.apiAlert.service.StationNumberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class StationNumberServiceTest {

    @Autowired
    private StationNumberService stationNumberService;

    @MockBean
    private DTOService dtoServiceMock;

    @MockBean
    private FirestationRepository firestationRepositoryMock;

    @MockBean
    private PersonRepository personRepositoryMock;

    @MockBean
    private AddressService addressServiceMock;

    //@MockBean
    //private StationNumberFirestation stationNumberFirestationMock;

    @MockBean
    private AdultOrChildrenService adultOrChildrenServiceMock;


    private Person person;
    private List<Firestation> firestationList;
    private List<String> addressList;
    private List<Person> personList;

    @BeforeEach
    private void setUp(){
        Firestation firestation = new Firestation();
        firestation.setStation("6");
        firestation.setAddress("11 rue du port");
        firestation.setId((long)21);
        Firestation firestation1 = new Firestation();
        firestation1.setStation("2");
        firestation1.setAddress("12 rue du port");
        firestation1.setId((long)12);
        firestationList = new ArrayList<>();
        firestationList.add(firestation);
        firestationList.add(firestation1);

        addressList = new ArrayList<>();
        addressList.add("11 rue du port");
        addressList.add("12 rue du port");

        person = new Person();
        person.setId((long)21);
        person.setEmail("ilybnnr@gmail.com");
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("11 rue du port");
        personList = new ArrayList<>();
        personList.add(person);
    }

    //problem here
   /* @Test
    public void testGetPersonsDetailsFromStationNumber(){
        List<Person> childrenList = new ArrayList<>();
        childrenList.add(person);
        List<Person> adultList = new ArrayList<>();
        Map<String, List<Person>> map = new HashMap<String, List<Person>>();
        map.put("childrenList", childrenList);
        map.put("adultList", adultList);
        List<Person> childrenList1 = new ArrayList<>();
        StationNumberFirestation stationNumberFirestation = new StationNumberFirestation("Ilyass", "Bennour","","","","");
        List<StationNumberFirestation> stationNumberFirestationList = new ArrayList<>();
        stationNumberFirestationList.add(stationNumberFirestation);
        StationNumberFirestationDTO stationNumberFirestationDTO = new StationNumberFirestationDTO(stationNumberFirestationList, 0, 1);


        when(firestationRepositoryMock.findDistinctByStation(org.mockito.ArgumentMatchers.anyString())).thenReturn(firestationList);
        when(addressServiceMock.addressListFromFirestationList(firestationList)).thenReturn(addressList);
        when(personRepositoryMock.findAllByAddressInOrderByAddress(addressList)).thenReturn(personList);
        when(adultOrChildrenServiceMock.listOfAllAdultAndChildren(personList, childrenList1, adultList)).thenReturn(map);
        when(dtoServiceMock.StationNumberDTO(personList)).thenReturn(stationNumberFirestationList);

        StationNumberFirestationDTO stationNumberFirestationDTO1 = stationNumberService.getPersonsDetailsFromStationNumber("1");
        assertThat(stationNumberFirestationDTO1).isEqualTo(stationNumberFirestationDTO);


    }*/
     @Test
    public void testFetPersonListFromStationNumber (){
        Person person1 = new Person();
         person.setEmail("Marie@gmail.com");
         person.setAddress("fgeg");
         personList.add(person1);
         Person person2 = new Person();
         person.setEmail("saly@outlook.fr");
         person.setAddress("fegfegeg");
         personList.add(person2);

         when(firestationRepositoryMock.findDistinctByStation(org.mockito.ArgumentMatchers.anyString())).thenReturn(firestationList);
         when(addressServiceMock.addressListFromFirestationList(firestationList)).thenReturn(addressList);
         when(personRepositoryMock.findAllByAddressInOrderByAddress(addressList)).thenReturn(personList);
         List<Person> result = stationNumberService.getPersonListFromStationNumber("1");

        assertThat(result).isEqualTo(personList);
        verify(personRepositoryMock, Mockito.times(1)).findAllByAddressInOrderByAddress(addressList);

     }
}
