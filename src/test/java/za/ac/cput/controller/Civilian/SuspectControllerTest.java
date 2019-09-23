package za.ac.cput.controller.Civilian;

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
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.factory.Civilian.SuspectFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuspectControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseURL = "http://localhost:8080/suspect";

    @Test
    public void create() {
        Suspect suspect = SuspectFactory.getSuspect(null, "Ryan", "Petersen", "Assault");
        suspect.setSuspectID("5555");
        ResponseEntity<Suspect> postResponse = testRestTemplate.postForEntity(baseURL + "/new", suspect, Suspect.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Suspect find = testRestTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        assertNotNull(find);
    }

    @Test
    public void update() {
        Suspect suspect = testRestTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        suspect.setSuspectName("Bryan");
        testRestTemplate.put(baseURL + "/update/" + "5555", suspect);
        Suspect suspectUpdated = testRestTemplate.getForObject(baseURL + "/update/" + "5555", Suspect.class);
        assertNotNull(suspectUpdated);

    }

    @Test
    public void delete() {

        Suspect suspect = testRestTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        assertNotNull(suspect);
        testRestTemplate.delete(baseURL + "/delete/" + "555");

        try {
            suspect = testRestTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
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