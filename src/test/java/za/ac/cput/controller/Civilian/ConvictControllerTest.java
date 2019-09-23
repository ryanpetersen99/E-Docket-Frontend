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
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.factory.Civilian.ConvictFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConvictControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/convict";

    @Test
    public void create() {
        Convict convict = ConvictFactory.getConvict(null, "Ryan", "Petersen", "Assault");
        convict.setConvictID("555");
        ResponseEntity<Convict> postResponse = restTemplate.postForEntity(baseURL + "/new", convict, Convict.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Convict lookingFor = restTemplate.getForObject(baseURL + "/find/" + "555", Convict.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Convict convict = restTemplate.getForObject(baseURL + "/find/" + "555", Convict.class);
        convict.setConvictName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", convict);
        Convict convictUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Convict.class);
        assertNotNull(convictUpdated);

    }

    @Test
    public void delete() {

        Convict convict = restTemplate.getForObject(baseURL + "/find/" + "555", Convict.class);
        assertNotNull(convict);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            convict = restTemplate.getForObject(baseURL + "/find/" + "555", Convict.class);
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