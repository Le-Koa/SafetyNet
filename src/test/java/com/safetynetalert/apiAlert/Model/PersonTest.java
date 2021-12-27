package com.safetynetalert.apiAlert.Model;

import com.jparams.verifier.tostring.ToStringVerifier;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class PersonTest {

    private Person person;

    @MockBean
    private ReadJsonFile readJsonFile;

    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private int age;
    private String medications;
    private String allergies;

    @BeforeEach
    private void setUp() {
        person = new Person();
        person.setId((long)99);
        person.setFirstName("Ilyass");
        person.setLastName("Bennour");
        person.setAddress("20 Rue du port aux dames");
        person.setCity("Draveil");
        person.setZip("91210");
        person.setPhone("0634234324");
        person.setEmail("testemail@emailtest.fr");
    }

    @Test
    public void testGetFirstName() throws Exception  {
        person.setFirstName("Ilyass");
       assertEquals("Ilyass", person.getFirstName());
    }

    @Test
    public void testGetLastName() throws  Exception {
        person.setLastName("Bennour");
        assertEquals("Bennour", person.getLastName());
    }
    @Test
    public void testGetAddress() throws  Exception {
        person.setAddress("20 Rue du port aux dames");
        assertEquals("20 Rue du port aux dames", person.getAddress());
    }
    @Test
    public void testGetCity() throws Exception {
        person.setCity("Draveil");
        assertEquals("Draveil", person.getCity());
    }
    @Test
    public void testZip() throws Exception {
        person.setZip("91210");
        assertEquals("91210", person.getZip());
    }
    @Test
    public void testPhone() throws Exception {
        person.setPhone("0634234324");
        assertEquals("0634234324", person.getPhone());
    }
    @Test
    public void testEmail() throws Exception{
        person.setEmail("testemail@emailtest.fr");
        assertEquals("testemail@emailtest.fr", person.getEmail());
    }
    @Test
    public void testGetMedication() throws Exception {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setMedications("omeprazol");
        assertEquals("omeprazol", medicalRecord.getMedications());
    }
    @Test
    public void testGetAllergies() throws Exception {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setAllergies("Fruit de mer");
        assertEquals("Fruit de mer",medicalRecord.getAllergies());
    }
    @Test
    public void testSetAge() throws Exception {
        person.setAge("04/29/1995", LocalDate.now());
        assertEquals(26, person.getAge());
    }

    @Test
    public void EqualsPerson() {
        EqualsVerifier.forClass(Person.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }
    @Test
    public void testToString(){
        String expected = "Person(" +
                "id=" + person.getId() +
                ", firstName=" + person.getFirstName() +
                ", lastName=" + person.getLastName() +
                ", address=" + person.getAddress() +
                ", city=" + person.getCity() +
                ", zip=" + person.getZip() +
                ", phone=" + person.getPhone() +
                ", email=" + person.getEmail() +
                ", age=" + person.getAge() +
                ", medications=" + medications +
                ", allergies=" + allergies +
                ')';
        Assert.assertEquals(expected, person.toString());
    }

}
