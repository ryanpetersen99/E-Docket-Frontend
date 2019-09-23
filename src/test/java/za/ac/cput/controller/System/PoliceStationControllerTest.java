package za.ac.cput.controller.System;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.factory.System.PoliceStationFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PoliceStationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/policeStation";

    @Test
    public void create() {
        PoliceStation policeStation = PoliceStationFactory.getPoliceStation(null,"5555");
        policeStation.setStationName("Plain");
        ResponseEntity<PoliceStation> postResponse = restTemplate.postForEntity(baseURL + "/new", policeStation, PoliceStation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        PoliceStation lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", PoliceStation.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        PoliceStation policeStation = restTemplate.getForObject(baseURL + "/find/" + "5555", PoliceStation.class);
        policeStation.setStationName("Manenburg");
        restTemplate.put(baseURL + "/update/" + "5555", policeStation);
        PoliceStation policeStationUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", PoliceStation.class);
        assertNotNull(policeStationUpdated);

    }

    @Test
    public void delete() {

        PoliceStation policeStation = restTemplate.getForObject(baseURL + "/find/" + "5555", PoliceStation.class);
        assertNotNull(policeStation);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            policeStation = restTemplate.getForObject(baseURL + "/find/" + "5555", PoliceStation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}