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
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.factory.System.EvidenceFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvidenceControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/evidence";

    @Test
    public void create() {
        Evidence evidence = EvidenceFactory.getEvidence(null, "Knife");
        evidence.setEvidenceID("555");
        ResponseEntity<Evidence> postResponse = restTemplate.postForEntity(baseURL + "/new", evidence, Evidence.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Evidence lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Evidence.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Evidence evidence = restTemplate.getForObject(baseURL + "/find/" + "5555", Evidence.class);
        evidence.setEvidenceDetails("Weapon");
        restTemplate.put(baseURL + "/update/" + "5555", evidence);
        Evidence evidenceUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Evidence.class);
        assertNotNull(evidenceUpdated);

    }

    @Test
    public void delete() {

        Evidence evidence = restTemplate.getForObject(baseURL + "/find/" + "5555", Evidence.class);
        assertNotNull(evidence);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            evidence = restTemplate.getForObject(baseURL + "/find/" + "5555", Evidence.class);
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