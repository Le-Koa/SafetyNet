package com.safetynetalert.apiAlert.Model;

import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest()
public class ChildAlertDTOTest {

    @MockBean
    private ReadJsonFile readJsonFile;

    private ChildAlertDTO childAlertDTO;

    private String firstName;
    private String lastName;
    private int age;

    @BeforeEach
    private void setUp() throws Exception {
        childAlertDTO = new ChildAlertDTO();

    }

    @Test
    public void testGetFirstName() throws Exception {
        childAlertDTO.setFirstName("Mage");
        assertThat(childAlertDTO.getFirstName()).isEqualTo("Mage");
    }
    @Test
    public void testGetLastName() throws Exception {
        childAlertDTO.setLastName("Blood");
        assertThat(childAlertDTO.getLastName()).isEqualTo("Blood");
    }
    @Test
    public void testGetAge() throws Exception {
        childAlertDTO.setAge(10);
        assertThat(childAlertDTO.getAge()).isEqualTo(10);
    }
    @Test
    public void EqualsPerson() {
        EqualsVerifier.simple().forClass(ChildAlertDTO.class).verify();
    }
    @Test
    public void testToString() {
        String expected = "ChildAlertDTO(" +
                "firstName=" + firstName +
                ", lastName=" + lastName +
                ", age=" + age +
                ')';
        Assert.assertEquals(expected, childAlertDTO.toString());
    }

}
