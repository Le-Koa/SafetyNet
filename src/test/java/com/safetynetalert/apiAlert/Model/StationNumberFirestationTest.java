package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class StationNumberFirestationTest {

    private StationNumberFirestation stationNumberFirestation;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
        stationNumberFirestation = new StationNumberFirestation("Cloudy","SK","ttvcloudy","123",
                "987-987","ttvland");
    }
    @Test
    public void testGetFirstName() throws Exception {
        stationNumberFirestation.setFirstName("Cloudy");
        assertEquals("Cloudy", stationNumberFirestation.getFirstName());
    }
    @Test
    public void testGetLastName() throws Exception {
        stationNumberFirestation.setLastName("SK");
        assertEquals("SK", stationNumberFirestation.getLastName());
    }
    @Test
    public void testGetAddress() throws Exception {
        stationNumberFirestation.setAddress("ttvcloudy");
        assertEquals("ttvcloudy", stationNumberFirestation.getAddress());
    }
    @Test
    public void testGetZip() throws Exception {
        stationNumberFirestation.setZip("123");
        assertEquals("123", stationNumberFirestation.getZip());
    }
    @Test
    public void testGetPhone() throws Exception {
        stationNumberFirestation.setPhone("987-987");
        assertEquals("987-987", stationNumberFirestation.getPhone());
    }
    @Test
    public void testGetCity() throws Exception {
        stationNumberFirestation.setCity("ttvland");
        assertEquals("ttvland", stationNumberFirestation.getCity());
    }
}
