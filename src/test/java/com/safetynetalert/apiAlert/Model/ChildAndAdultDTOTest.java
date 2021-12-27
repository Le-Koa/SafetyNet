package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class ChildAndAdultDTOTest {

    private ChildAndAdultDTO childAndAdultDTO;
    private List<ChildAlertDTO> childList;
    private  List<ChildAlertDTO> adultList;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
        ChildAlertDTO adult = new ChildAlertDTO("Marc", "Zuck", 29);
        ChildAlertDTO children = new ChildAlertDTO("So", "Mayd", 2);
        ChildAlertDTO adult1 = new ChildAlertDTO("Mage", "Blood", 57);
        ChildAlertDTO children1 = new ChildAlertDTO("Hunter", "Heqd", 7);
        adultList = new ArrayList<>();
        adultList.add(adult);
        adultList.add(adult1);
        childList = new ArrayList<>();
        childList.add(children);
        childList.add(children1);
        childAndAdultDTO = new ChildAndAdultDTO (childList, adultList);
    }
    @Test
    public void testGetAdultList() throws Exception {
        childAndAdultDTO.setAdultList(adultList);
        assertEquals(adultList, childAndAdultDTO.getAdultList());
    }
    @Test
    public void testGetChildList() throws Exception {
        childAndAdultDTO.setChildList(childList);
        assertEquals(childList, childAndAdultDTO.getChildList());
    }
}
