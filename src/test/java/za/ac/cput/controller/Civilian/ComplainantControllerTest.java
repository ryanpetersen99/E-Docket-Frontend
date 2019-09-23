package za.ac.cput.controller.Civilian;
//Ryan Petersen

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
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.factory.Civilian.ComplainantFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComplainantControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseURL = "http://localhost:8080/complainant";

    @Test
    public void create() {
        Complainant complainant = ComplainantFactory.getComplainant(null, "Ryan", "Petersen", "Assaulted");
        complainant.setComplainantID("555");
        ResponseEntity<Complainant> postResponse = testRestTemplate.postForEntity(baseURL + "/new", complainant, Complainant.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Complainant lookingFor = testRestTemplate.getForObject(baseURL + "/find/" + "555", Complainant.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Complainant complainant = testRestTemplate.getForObject(baseURL + "/find/" + "555", Complainant.class);
        complainant.setComplainantName("Bryan");
        testRestTemplate.put(baseURL + "/update/" + "5555", complainant);
        Complainant complainantUpdated = testRestTemplate.getForObject(baseURL + "/update/" + "5555", Complainant.class);
        assertNotNull(complainantUpdated);

    }

    @Test
    public void delete() {

        Complainant complainant = testRestTemplate.getForObject(baseURL + "/find/" + "555", Complainant.class);
        assertNotNull(complainant);
        testRestTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            complainant = testRestTemplate.getForObject(baseURL + "/find/" + "555", Complainant.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}