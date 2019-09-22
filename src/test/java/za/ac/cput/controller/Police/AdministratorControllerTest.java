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
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.factory.Police.AdministratorFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdministratorControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/administrator";

    @Test
    public void create() {
        Administrator administrator = AdministratorFactory.getAdministrator(null, "Ryan", "Petersen");
        administrator.setAdminID("555");
        ResponseEntity<Administrator> postResponse = restTemplate.postForEntity(baseURL + "/new", administrator, Administrator.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        Administrator lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", Administrator.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        Administrator administrator = restTemplate.getForObject(baseURL + "/find/" + "5555", Administrator.class);
        administrator.setAdminName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", administrator);
        Administrator administratorUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", Administrator.class);
        assertNotNull(administratorUpdated);

    }

    @Test
    public void delete() {

        Administrator administrator = restTemplate.getForObject(baseURL + "/find/" + "5555", Administrator.class);
        assertNotNull(administrator);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            administrator = restTemplate.getForObject(baseURL + "/find/" + "5555", Administrator.class);
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