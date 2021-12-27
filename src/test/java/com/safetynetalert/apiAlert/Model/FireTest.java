package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class FireTest {

    private Fire fire;
    private List<FireDTO> fireDTOList;
    private List<String> firestationNumberList;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
    FireDTO fireDTO = new FireDTO("Mage",
            19,
            "456-456",
            "Blood",
            "chat");
    FireDTO fireDTO1 = new FireDTO("Head",
            8,
            "654-654",
            "Hunter",
            "chien");
    fireDTOList = new ArrayList<>();
    fireDTOList.add(fireDTO);
    fireDTOList.add(fireDTO1);
    firestationNumberList = new ArrayList<>();
    fire = new Fire(fireDTOList, firestationNumberList);
    }
    @Test
    public void testGetFirestationNumberList() throws Exception {
        firestationNumberList.add("5");
        fire.setFirestationNumberList(firestationNumberList);
        assertEquals(firestationNumberList, fire.getFirestationNumberList());
    }
    @Test
    public void simpleEqualsPersonInfo() {
        EqualsVerifier.simple().forClass(Fire.class).verify();
    }
    @Test
    public void testToString() {
        String expected = "Fire(personList=" + fireDTOList + ", firestationNumberList=" + firestationNumberList
                + ")";
        Assert.assertEquals(expected, fire.toString());
    }
}
