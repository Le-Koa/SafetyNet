/*package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.FireDTO;
import com.safetynetalert.apiAlert.Model.FloodFireDTO;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.FirestationRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;

import com.safetynetalert.apiAlert.service.AddressServiceImpl;
import com.safetynetalert.apiAlert.service.DTOService;
import com.safetynetalert.apiAlert.service.FloodService;
import com.safetynetalert.apiAlert.service.PersonInfoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FloodServiceTest {

    @Autowired
    private FloodService floodService;

    @MockBean
    private AddressServiceImpl addressService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private PersonInfoServiceImpl personInfoService;

    @MockBean
    private  DTOService dtoService;

    @MockBean
    private FirestationRepository firestationRepository;

    //problem here
    @Test
    public void testGetInfoByAddress() {
        List<String> stationNumberList = new ArrayList<>();
        stationNumberList.add("7");
        stationNumberList.add("10");
        List<String> addressList = new ArrayList<>();
        addressList.add("12 rue du port");
        Person person = new Person();
        person.setId((long)21);
        person.setEmail("ilybnnr@gmail.com");
        //person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("12 rue du port");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        String address = "12 rue du port";
        FireDTO fireDTO = new FireDTO("Bennour", 26,"123-123-123","", "");
        List<FireDTO> fireDTOList = new ArrayList<>();
        fireDTOList.add(fireDTO);
        FloodFireDTO floodFireDTO = new FloodFireDTO(fireDTOList,"12 rue du port");
        List<FloodFireDTO> floodFireDTOList = new ArrayList<>();
        floodFireDTOList.add(floodFireDTO);

        when(addressService.addressListFromStationNumberList(stationNumberList)).thenReturn(addressList);
        when(personRepository.findDistinctByAddress(address)).thenReturn(personList);
        doNothing().when(personInfoService).setAgeAndMedicationsAndAllergies(personList, LocalDate.now());
        when(dtoService.FireDTO(personList)).thenReturn(fireDTOList);

        List<FloodFireDTO> floodFireDTOList1 = floodService.getInfoByAddress(stationNumberList);
        assertThat(floodFireDTOList1).isEqualTo(floodFireDTOList);
    }
} */
