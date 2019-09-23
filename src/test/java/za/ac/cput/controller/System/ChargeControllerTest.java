package za.ac.cput.controller.System;

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
import za.ac.cput.domain.System.Charge;
import za.ac.cput.factory.System.ChargeFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChargeControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/charge";

    @Test
    public void create() {
        Charge charge = ChargeFactory.getCharge(null, "44");
        charge.setNatureOfCharge("assault");
        ResponseEntity<Charge> postResponse = restTemplate.postForEntity(baseURL + "/new", charge, Charge.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

//    @Test
//    public void update() {
//        Charge charge = restTemplate.getForObject(baseURL + "/find/" + "assault" , Charge.class);
//        charge.setNatureOfCharge("murder");
//        restTemplate.put(baseURL + "/update/" + "assault" , charge);
//        Charge chargeUpdated = restTemplate.getForObject(baseURL + "/update/" + "assault" , Charge.class);
//        assertNotNull(chargeUpdated);
//
//    }

    @Test
    public void delete() {

        Charge charge = restTemplate.getForObject(baseURL + "/find/" + "assault", Charge.class);
        assertNotNull(charge);
        restTemplate.delete(baseURL + "/delete/" + "assault");

        try {
            charge = restTemplate.getForObject(baseURL + "/find/" + "assault", Charge.class);
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