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
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.factory.Civilian.WitnessFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WitnessControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/witness";

    @Test
    public void create() {
        Witness witness = WitnessFactory.getWitness(null, "Ryan", "Petersen", "Assaulted");
        witness.setWitnessID("5555");
        ResponseEntity<Witness> postResponse = restTemplate.postForEntity(baseURL + "/new", witness, Witness.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Witness lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Witness.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Witness witness = restTemplate.getForObject(baseURL + "/find/" + "5555", Witness.class);
        witness.setWitnessName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", witness);
        Witness witnessUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Witness.class);
        assertNotNull(witnessUpdated);

    }

    @Test
    public void delete() {

        Witness witness = restTemplate.getForObject(baseURL + "/find/" + "5555", Witness.class);
        assertNotNull(witness);
        restTemplate.delete(baseURL + "/delete/" + "555");

        try {
            witness = restTemplate.getForObject(baseURL + "/find/" + "5555", Witness.class);
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