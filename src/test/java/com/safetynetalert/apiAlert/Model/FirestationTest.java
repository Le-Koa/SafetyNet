package com.safetynetalert.apiAlert.Model;


import com.jparams.verifier.tostring.ToStringVerifier;
import com.safetynetalert.apiAlert.service.ReadJsonFile;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest()
public class FirestationTest {

    private Firestation firestation;

    @MockBean
    private ReadJsonFile readJsonFile;

    @BeforeEach
    private void setUp() {
        firestation = new Firestation();
    }
    @Test
    public void testAddress() throws Exception {
        firestation.setAddress("1 Street firestation");
        assertEquals("1 Street firestation", firestation.getAddress());
    }
    @Test
    public void testStation() throws Exception {
        firestation.setStation("10");
        assertEquals("10", firestation.getStation());
    }

    @Test
    public void testId() {
        firestation.setId((long)10);
        assertEquals(10, firestation.getId());
    }
    @Test
    public void simpleEqualsFireStation() {
        EqualsVerifier.forClass(Firestation.class).suppress(Warning.ALL_FIELDS_SHOULD_BE_USED).verify();
    }

}
