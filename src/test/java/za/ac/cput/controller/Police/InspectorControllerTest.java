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
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.factory.Police.InspectorFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InspectorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/inspector";

    @Test
    public void create() {
        Inspector inspector = InspectorFactory.getInspector(null, "Ryan", "Petersen", "Assaulted");
        inspector.setInspectorID("555");
        ResponseEntity<Inspector> postResponse = restTemplate.postForEntity(baseURL + "/new", inspector, Inspector.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

//    @Test
//    public void findById() {
//        Inspector find = restTemplate.getForObject(baseURL + "/find/" + "555", Inspector.class);
//        assertNotNull(find);
//    }

//    @Test
//    public void update() {
//        Inspector inspector = restTemplate.getForObject(baseURL + "/find/" + "555", Inspector.class);
//        inspector.setInspectorName("yan");
//        restTemplate.put(baseURL + "/update/" + "555", inspector);
//        Inspector inspectorUpdated = restTemplate.getForObject(baseURL + "/update/" + "555", Inspector.class);
//        assertNotNull(inspectorUpdated);
//    }

    @Test
    public void delete() {

        Inspector inspector = restTemplate.getForObject(baseURL + "/find/" + "555", Inspector.class);
        assertNotNull(inspector);
        restTemplate.delete(baseURL + "/delete/" + "555");

        try {
            inspector = restTemplate.getForObject(baseURL + "/find/" + "555", Inspector.class);
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