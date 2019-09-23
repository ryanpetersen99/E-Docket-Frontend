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
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.factory.System.PendingCaseFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PendingCaseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/pendingCase";

    @Test
    public void create() {
        PendingCase pendingCase = PendingCaseFactory.getPendingCase(null, "Ryan", 2, "Assaulted");
        pendingCase.setCaseID("555");
        ResponseEntity<PendingCase> postResponse = restTemplate.postForEntity(baseURL + "/new", pendingCase, PendingCase.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        PendingCase lookingFor = restTemplate.getForObject(baseURL + "/find/" + "555", PendingCase.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        PendingCase pendingCase = restTemplate.getForObject(baseURL + "/find/" + "555", PendingCase.class);
        pendingCase.setCaseNoOfDockets(20);
        restTemplate.put(baseURL + "/update/" + "555", pendingCase);
        PendingCase pendingCaseUpdated = restTemplate.getForObject(baseURL + "/update/" + "555", PendingCase.class);
        assertNotNull(pendingCaseUpdated);

    }

    @Test
    public void delete() {

        PendingCase pendingCase = restTemplate.getForObject(baseURL + "/find/" + "555", PendingCase.class);
        assertNotNull(pendingCase);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            pendingCase = restTemplate.getForObject(baseURL + "/find/" + "555", PendingCase.class);
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