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
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.factory.Police.ChiefFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChiefControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/chief";

    @Test
    public void create() {
        Chief chief = ChiefFactory.getChief(null, "Ryan", "Petersen", "Assaulted");
        chief.setChiefID("5555");
        ResponseEntity<Chief> postResponse = restTemplate.postForEntity(baseURL + "/new", chief, Chief.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Chief lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Chief.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Chief chief = restTemplate.getForObject(baseURL + "/find/" + "5555", Chief.class);
        chief.setChiefName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", chief);
        Chief chiefUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Chief.class);
        assertNotNull(chiefUpdated);

    }

    @Test
    public void delete() {

        Chief chief = restTemplate.getForObject(baseURL + "/find/" + "5555", Chief.class);
        assertNotNull(chief);
        restTemplate.delete(baseURL + "/delete/" + "555");

        try {
            chief = restTemplate.getForObject(baseURL + "/find/" + "5555", Chief.class);
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