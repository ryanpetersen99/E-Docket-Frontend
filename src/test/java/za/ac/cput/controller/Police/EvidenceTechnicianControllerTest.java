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
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.factory.Police.Evidence_TechnicianFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvidenceTechnicianControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private String baseURL = "http://localhost:8080/evidenceTechnician";

    @Test
    public void create() {
        EvidenceTechnician evidenceTech = Evidence_TechnicianFactory.getEvidence_Technician(null, "Ryan", "Petersen", "5555");
        evidenceTech.setEvidenceTechID("555");
        ResponseEntity<EvidenceTechnician> postResponse = restTemplate.postForEntity(baseURL + "/new", evidenceTech, EvidenceTechnician.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        EvidenceTechnician lookingFor = restTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        EvidenceTechnician evidenceTech = restTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        evidenceTech.setEvidenceTechName("Bryan");
        restTemplate.put(baseURL + "/update/" + "5555", evidenceTech);
        EvidenceTechnician evidenceTechUpdated = restTemplate.getForObject(baseURL + "/update/" + "5555", EvidenceTechnician.class);
        assertNotNull(evidenceTechUpdated);

    }

    @Test
    public void delete() {

        EvidenceTechnician evidenceTech = restTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        assertNotNull(evidenceTech);
        restTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            evidenceTech = restTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
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