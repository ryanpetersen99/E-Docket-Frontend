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
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.factory.Civilian.VictimFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VictimControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/victim";

    @Test
    public void create() {
        Victim victim = VictimFactory.getVictim(null, "Ryan", "Petersen", "Assaulted");
        victim.setVictimID("555");
        ResponseEntity<Victim> postResponse = restTemplate.postForEntity(baseURL + "/new", victim, Victim.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Victim lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Victim.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Victim victim = restTemplate.getForObject(baseURL + "/find/" + "5555", Victim.class);
        victim.setVictimName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", victim);
        Victim victimUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Victim.class);
        assertNotNull(victimUpdated);

    }

    @Test
    public void delete() {

        Victim victim = restTemplate.getForObject(baseURL + "/find/" + "5555", Victim.class);
        assertNotNull(victim);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            victim = restTemplate.getForObject(baseURL + "/find/" + "5555", Victim.class);
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