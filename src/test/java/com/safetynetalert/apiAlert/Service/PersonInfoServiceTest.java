package com.safetynetalert.apiAlert.Service;

import com.safetynetalert.apiAlert.Model.MedicalRecord;
import com.safetynetalert.apiAlert.Model.Person;
import com.safetynetalert.apiAlert.Model.PersonInfo;
import com.safetynetalert.apiAlert.repository.MedicalRecordRepository;
import com.safetynetalert.apiAlert.repository.PersonRepository;
import com.safetynetalert.apiAlert.service.DTOService;
import com.safetynetalert.apiAlert.service.PersonInfoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PersonInfoServiceTest {

    @Autowired
    private PersonInfoService personInfoService;


    @MockBean
    private PersonRepository personRepositoryMock;

    @MockBean
    private MedicalRecordRepository medicalRecordRepositoryMock;

    @MockBean
    private Person personMock;

    @MockBean
    private MedicalRecord medicalRecordMock;

    @MockBean
    private DTOService dtoService;



    private MedicalRecord medicalRecord1;
    private List<MedicalRecord> medicalRecordList;
    private Person person;
    private List<Person> personList;

    @BeforeEach
    private void setUp() {
        medicalRecord1 = new MedicalRecord();
        medicalRecord1.setBirthdate("01/01/2019");
        medicalRecordList = new ArrayList<>();
        medicalRecordList.add(medicalRecord1);
        person = new Person();
        person.setEmail("ilybnnr@gmail");
        person.setAddress("11 rue du port");
       // person.setFirstName("Ilyass");
       // person.setLastName("Bennour");
        personList = new ArrayList<>();
        personList.add(person);
    }
    @Test
    public void testSetAgeAndMedicationsAndAllergies(){
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");

        when(medicalRecordRepositoryMock.findByFirstNameAndLastName("Ilyass", "Bennour")).thenReturn(medicalRecordList);
        when(medicalRecordMock.getBirthdate()).thenReturn("01/01/2019");

        personInfoService.setAgeAndMedicationsAndAllergies(personList, LocalDate.of(2021, 11, 25));
        assertThat(person.getAge()).isEqualTo(2);
    }

    @Test
    public void testPersonListBylastName() throws ParseException {
        when(personRepositoryMock.findByLastName("Bennour")).thenReturn(personList);
        when(medicalRecordRepositoryMock.findByFirstNameAndLastName("Ilyass", "Bennour")).thenReturn(medicalRecordList);
        when(medicalRecordMock.getBirthdate()).thenReturn("01/01/2019");
        doNothing().when(personMock).setAge("01/01/2019", LocalDate.of(2021, 11,25));
        doNothing().when(personMock).setMedicationAndAllergies(medicalRecord1);

        List<Person> personList1 = personInfoService.personListBylastName("Bennour");
        assertThat(personList1).isNotEqualTo(null);

    }
    @Test
    public void testPersonListByfirstNameAndLastName(){
        when(personRepositoryMock.findByFirstNameAndLastNameAllIgnoreCase("Ilyass","Bennour")).thenReturn(personList);
        when(medicalRecordRepositoryMock.findByFirstNameAndLastName("Ilyass","Bennour")).thenReturn(medicalRecordList);
        when(medicalRecordMock.getBirthdate()).thenReturn("29/05/2016");
        doNothing().when(personMock).setAge("29/05/2016", LocalDate.now());
        doNothing().when(personMock).setMedicationAndAllergies(medicalRecord1);

        List<Person> personList2 = personInfoService.PersonListByFirstAndLastName("Ilyass","Bennour");
        assertThat(personList2).isNotEqualTo(null);
    }
    @Test
    public void testGetPersonListByFirstNameAndLastNameThenOnlyLastName(){
        PersonInfo personInfo = new PersonInfo("Bennour","11 rue du port","Draveil","91210",
                25,"bnnr@gmail.fr","", "");
        List<PersonInfo> personInfoList = new ArrayList<>();
        personInfoList.add(personInfo);

        when(personRepositoryMock.findByFirstNameAndLastNameAllIgnoreCase("Ilyass","Bennour")).thenReturn(personList);
        when(medicalRecordRepositoryMock.findByFirstNameAndLastName("Ilyass","Bennour")).thenReturn(medicalRecordList);
        when(medicalRecordMock.getBirthdate()).thenReturn("29/05/2016");
        doNothing().when(personMock).setAge("29/05/2016", LocalDate.now());
        doNothing().when(personMock).setMedicationAndAllergies(medicalRecord1);
        when(dtoService.PersonInfoDTO(personList)).thenReturn(personInfoList);

        List<PersonInfo> personInfoList2 = personInfoService.getPersonListByFirstNameAndLastNameThenOnlyLastName(
                "Ilyass","Bennour");
        assertThat(personInfoList2).isEqualTo(personInfoList);
    }
}
