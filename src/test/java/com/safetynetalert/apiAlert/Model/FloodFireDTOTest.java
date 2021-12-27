package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class FloodFireDTOTest {

    private FloodFireDTO floodFireDTO;
    private List<FireDTO> personList;
    private String address;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
        FireDTO fireDTO = new FireDTO("Bennour",
                12,
                "345-345",
                "Doliprane",
                "");
        FireDTO fireDTO1 = new FireDTO("Najibi",
                70,
                "765-765",
                "Valium",
                "Arachide");
        personList = new ArrayList<>();
        personList.add(fireDTO);
        personList.add(fireDTO1);
        address = "20 rue de la treille";
        floodFireDTO = new FloodFireDTO(personList,address);
    }
    @Test
    public void testGetAddress() throws Exception {
        floodFireDTO.setAddress("20 rue de la treille");
        assertEquals(address, floodFireDTO.getAddress());
    }
    @Test
    public void testGetPersonList() throws Exception {
        FireDTO fireDTO = new FireDTO("Ramon", 1,"08080","","");
        personList.add(fireDTO);
        floodFireDTO.setPersonList(personList);
        assertEquals(personList, floodFireDTO.getPersonList());
    }
    @Test
    public void simpleEqualsPersonInfoByAddress() {
        EqualsVerifier.simple().forClass(FloodFireDTO.class).verify();
    }
    @Test
    public void testToString() {
        String expected = "FloodFireDTO(personList=" + personList+ ", address="+ address +")";
        Assert.assertEquals(expected, floodFireDTO.toString());
    }
}
