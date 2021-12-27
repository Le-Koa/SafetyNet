/*package com.safetynetalert.apiAlert.Service;



import com.safetynetalert.apiAlert.Model.ChildAlertDTO;
import com.safetynetalert.apiAlert.Model.ChildAndAdultDTO;
import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;

import com.safetynetalert.apiAlert.service.ChildAlertService;
import com.safetynetalert.apiAlert.service.DTOService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ChildAlertServiceTest {

    @Autowired
    private ChildAlertService childAlertService;

    @MockBean
    private PersonRepository personRepository;

    @MockBean
    private MedicalRecordRepository medicalRecordRepository;

    @MockBean
    private DTOService dtoService;





    //childrenList / adultList From adress
    //problem here
    @Test
    public void testAdultAndChildrenList() {
        Person person = new Person();
        person.setId((long)5);
        person.setFirstName("Bennour");
        person.setLastName("Ilyass");
        person.setEmail("ilybnnr@gmail.com");
        person.setAddress("12 rue du port");
        List<Person> personList = new ArrayList<>();
        personList.add(person);
        String address = "11 rue du port";
        MedicalRecord medicalRecord1 = new MedicalRecord();
        medicalRecord1.setBirthdate("16/06/2020");
        List<MedicalRecord> medicalRecordList = new ArrayList<>();
        medicalRecordList.add(medicalRecord1);
        ChildAlertDTO childAlertDTO = new ChildAlertDTO(1, "Ilyass" , "Bennour");
        List<ChildAlertDTO> childAlertDTOList = new ArrayList<>();
        childAlertDTOList.add(childAlertDTO);
        List<ChildAlertDTO> childAlertDTOList1 = new ArrayList<>();
        ChildAndAdultDTO childAndAdultDTO = new ChildAndAdultDTO(childAlertDTOList,childAlertDTOList1);

        when(personRepository.findDistinctByAddress(address)).thenReturn(personList);
        when(medicalRecordRepository.findByFirstNameAndLastName("Bennour","Ilyass")).thenReturn(medicalRecordList);
        when(dtoService.ChildAlertDTO(personList)).thenReturn(childAlertDTOList);

        ChildAndAdultDTO childAndAdultDTO1 = childAlertService.adultAndChildrenList(address);
        assertThat(childAndAdultDTO1).isEqualTo(childAndAdultDTO);

    }
}*/
