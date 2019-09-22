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
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuspectControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/suspect";

    @Test
    public void create() {
        Suspect suspect = SuspectFactory.getSuspect(null, "Ryan", "Petersen", "Assault");
        suspect.setSuspectID("555");
        ResponseEntity<Suspect> postResponse = restTemplate.postForEntity(baseURL + "/new", suspect, Suspect.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Suspect lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Suspect suspect = restTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        suspect.setSuspectName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", suspect);
        Suspect suspectUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Suspect.class);
        assertNotNull(suspectUpdated);

    }

    @Test
    public void delete() {

        Suspect suspect = restTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
        assertNotNull(suspect);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            suspect = restTemplate.getForObject(baseURL + "/find/" + "5555", Suspect.class);
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