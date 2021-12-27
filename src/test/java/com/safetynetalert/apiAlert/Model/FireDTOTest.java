package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class FireDTOTest {

    private FireDTO fireDTO;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
        fireDTO = new FireDTO("Dolph",12,"2121-2121","paracetamol","Chien");
    }
    @Test
    public void testGetLastName()throws Exception {
        fireDTO.setLastName("Dolph");
        assertEquals("Dolph", fireDTO.getLastName());
    }
    @Test
    public void testGetAge() throws Exception {
        fireDTO.setAge(12);
        assertEquals(12, fireDTO.getAge());
    }
    @Test
    public void testGetPhone() throws Exception {
        fireDTO.setPhone("2121-2121");
        assertEquals("2121-2121", fireDTO.getPhone());
    }
    @Test
    public void testGetMedications() throws Exception {
        fireDTO.setMedications("paracetamol");
        assertEquals("paracetamol",fireDTO.getMedications());
    }
    @Test
    public void testGetAllergies() throws Exception {
        fireDTO.setAllergies("Chien");
        assertEquals("Chien", fireDTO.getAllergies());
    }
}
