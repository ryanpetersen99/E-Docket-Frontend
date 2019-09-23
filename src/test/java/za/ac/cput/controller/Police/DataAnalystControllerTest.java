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
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.factory.Police.DataAnalystFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataAnalystControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/dataAnalyst";

    @Test
    public void create() {
        DataAnalyst dataAnalyst = DataAnalystFactory.getDataAnalyst(null, "Ryan", "Petersen");
        dataAnalyst.setDaID("555");
        ResponseEntity<DataAnalyst> postResponse = restTemplate.postForEntity(baseURL + "/new", dataAnalyst, DataAnalyst.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        DataAnalyst lookingFor = restTemplate.getForObject(baseURL + "/find/" + "555", DataAnalyst.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        DataAnalyst dataAnalyst = restTemplate.getForObject(baseURL + "/find/" + "555", DataAnalyst.class);
        dataAnalyst.setDaName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", dataAnalyst);
        DataAnalyst dataAnalystUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", DataAnalyst.class);
        assertNotNull(dataAnalystUpdated);

    }

    @Test
    public void delete() {

        DataAnalyst dataAnalyst = restTemplate.getForObject(baseURL + "/find/" + "555", DataAnalyst.class);
        assertNotNull(dataAnalyst);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            dataAnalyst = restTemplate.getForObject(baseURL + "/find/" + "5555", DataAnalyst.class);
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