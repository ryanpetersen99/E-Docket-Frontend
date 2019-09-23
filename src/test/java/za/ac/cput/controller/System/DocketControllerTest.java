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
import za.ac.cput.domain.System.Docket;
import za.ac.cput.factory.System.DocketFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DocketControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/docket";

    @Test
    public void create() {
        Docket docket = DocketFactory.getDocket(null,"10 May 2019");
        docket.setDocketID("555");
        ResponseEntity<Docket> postResponse = restTemplate.postForEntity(baseURL + "/new", docket, Docket.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Docket lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Docket.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Docket docket = restTemplate.getForObject(baseURL + "/find/" + "5555", Docket.class);
        docket.setDocketID("7777");
        restTemplate.put(baseURL + "/update/" + "5555", docket);
        Docket docketUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Docket.class);
        assertNotNull(docketUpdated);

    }

    @Test
    public void delete() {

        Docket docket = restTemplate.getForObject(baseURL + "/find/" + "5555", Docket.class);
        assertNotNull(docket);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            docket = restTemplate.getForObject(baseURL + "/find/" + "5555", Docket.class);
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