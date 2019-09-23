package za.ac.cput.controller.Police;

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
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.factory.Police.OfficerFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfficerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/officer";

    @Test
    public void create() {
        Officer officer = OfficerFactory.getOfficer(null, "Ryan", "Petersen", "Assaulted");
        officer.setOfficerID("555");
        ResponseEntity<Officer> postResponse = restTemplate.postForEntity(baseURL + "/new", officer, Officer.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Officer lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Officer.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Officer officer = restTemplate.getForObject(baseURL + "/find/" + "5555", Officer.class);
        officer.setOfficerName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", officer);
        Officer officerUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Officer.class);
        assertNotNull(officerUpdated);

    }

    @Test
    public void delete() {

        Officer officer = restTemplate.getForObject(baseURL + "/find/" + "5555", Officer.class);
        assertNotNull(officer);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            officer = restTemplate.getForObject(baseURL + "/find/" + "5555", Officer.class);
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