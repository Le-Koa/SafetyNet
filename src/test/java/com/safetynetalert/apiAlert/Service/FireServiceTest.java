package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.Fire;
import com.safetynetalert.apiAlert.Model.FireDTO;
import com.safetynetalert.apiAlert.Model.Firestation;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import com.safetynetalert.apiAlert.service.DTOService;
import com.safetynetalert.apiAlert.service.FireService;
import com.safetynetalert.apiAlert.service.FirestationService;
import com.safetynetalert.apiAlert.service.PersonInfoService;
import com.zaxxer.hikari.util.FastList;
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
public class FireServiceTest {

    @Autowired
    private FireService fireService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private PersonInfoService personInfoService;

    @MockBean
    private FirestationService firestationService;

    @MockBean
    private DTOService dtoService;

    @Test
    public void testPersonListWithStationNumber(){
        Person person = new Person();
        person.setId((long)21);
        person.setEmail("ilybnnr@gmail.com");
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("11 rue du port");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        String address = "12 rue du port";
        Firestation firestation = new Firestation();
        List<Firestation> firestationList = new ArrayList<>();
        firestationList.add(firestation);
        List<String> firestationNumberList = new ArrayList<>();
        FireDTO fireDTO = new FireDTO("Bennour", 26,"123-123-123", "Doliprane", "");
        List<FireDTO> fireDTOList = new ArrayList<>();
        fireDTOList.add(fireDTO);
        Fire fire = new Fire(fireDTOList, firestationNumberList);

        when(personRepository.findDistinctByAddress(address)).thenReturn(personList);
        doNothing().when(personInfoService).setAgeAndMedicationsAndAllergies(personList, LocalDate.now());
        when(firestationService.getStationNumberList(firestationList)).thenReturn(firestationNumberList);
        when(dtoService.FireDTO(personList)).thenReturn(fireDTOList);

        Fire fire1 = fireService.PersonListWithStationNumber(address);
        assertThat(fire1).isEqualTo(fire);

    }
}
