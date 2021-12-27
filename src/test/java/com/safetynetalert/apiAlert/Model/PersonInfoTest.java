package com.safetynetalert.apiAlert.Model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest()
public class PersonInfoTest {

    private PersonInfo personInfo;

    private String lastName;
    private int age;
    private String address;
    private String city;
    private String zip;
    private String email;
    private String medications;
    private String allergies;

    @BeforeEach
    private void setUP(){
        personInfo = new PersonInfo(lastName,  address, city, zip, age, email, allergies, medications);
        personInfo.setLastName("Bennour");
        personInfo.setAge(26);
        personInfo.setAddress("11 rue du port");
        personInfo.setCity("Draveil");
        personInfo.setZip("91210");
        personInfo.setEmail("bnnr@gmail.fr");
        personInfo.setMedications("Doliprane");
        personInfo.setAllergies("Foin");

    }
    @Test
    public void testlastName(){
        assertThat(personInfo.getLastName()).isEqualTo("Bennour");
    }
    @Test
    public void testage(){
        assertThat(personInfo.getAge()).isEqualTo(26);
    }
    @Test
    public void testaddress(){
        assertThat(personInfo.getAddress()).isEqualTo("11 rue du port");
    }
    @Test
    public void testcity(){
        assertThat(personInfo.getCity()).isEqualTo("Draveil");
    }
    @Test
    public void testzip(){
        assertThat(personInfo.getZip()).isEqualTo("91210");
    }
    @Test
    public void testemail(){
        assertThat(personInfo.getEmail()).isEqualTo("bnnr@gmail.fr");
    }
    @Test
    public void testmedications(){
        assertThat(personInfo.getMedications()).isEqualTo("Doliprane");
    }
    @Test
    public void testallergies(){
        assertThat(personInfo.getAllergies()).isEqualTo("Foin");
    }

    @Test
    public void EqualsPersonInfo(){
        EqualsVerifier.simple().forClass(PersonInfo.class).verify();
    }
    @Test
    public void testToString(){
        String expected= "PersonInfo(" +
                "lastName=" + personInfo.getLastName() +
                ", age=" + personInfo.getAge() +
                ", address=" + personInfo.getAddress() +
                ", city=" + personInfo.getCity() +
                ", zip=" + personInfo.getZip() +
                ", email=" + personInfo.getEmail() +
                ", medications=" + personInfo.getMedications() +
                ", allergies=" + personInfo.getAllergies() +
                ')';
        Assert.assertEquals(expected, personInfo.toString());
    }
}
