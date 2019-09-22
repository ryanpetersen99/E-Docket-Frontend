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
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.factory.System.SolvedCaseFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SolvedCaseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/solvedCase";

    @Test
    public void create() {
        SolvedCase solvedCase = SolvedCaseFactory.getSolvedCase(null, "Ryan", 10, "Assaulted");
        solvedCase.setCaseID("555");
        ResponseEntity<SolvedCase> postResponse = restTemplate.postForEntity(baseURL + "/new", solvedCase, SolvedCase.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        SolvedCase lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", SolvedCase.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        SolvedCase solvedCase = restTemplate.getForObject(baseURL + "/find/" + "5555", SolvedCase.class);
        solvedCase.setCaseNoOfDockets(40);
        restTemplate.put(baseURL + "/update/" + "5555", solvedCase);
        SolvedCase solvedCaseUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", SolvedCase.class);
        assertNotNull(solvedCaseUpdated);

    }

    @Test
    public void delete() {

        SolvedCase solvedCase = restTemplate.getForObject(baseURL + "/find/" + "5555", SolvedCase.class);
        assertNotNull(solvedCase);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            solvedCase = restTemplate.getForObject(baseURL + "/find/" + "5555", SolvedCase.class);
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