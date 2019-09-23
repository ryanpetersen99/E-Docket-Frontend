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
import za.ac.cput.factory.Police.EvidenceTechnicianFactory;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EvidenceTechnicianControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String baseURL = "http://localhost:8080/evidenceTechnician";

    @Test
    public void create() {
        EvidenceTechnician evidenceTech = EvidenceTechnicianFactory.getEvidence_Technician(null, "Ryan", "Petersen", "5566");
        evidenceTech.setEvidenceTechID("5555");
        ResponseEntity<EvidenceTechnician> postResponse = testRestTemplate.postForEntity(baseURL + "/new", evidenceTech, EvidenceTechnician.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void findById() {
        EvidenceTechnician lookingFor = testRestTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        assertNotNull(lookingFor);
    }

    @Test
    public void update() {
        EvidenceTechnician evidenceTech = testRestTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        evidenceTech.setEvidenceTechName("Bryan");
        testRestTemplate.put(baseURL + "/update/" + "5555", evidenceTech);
        EvidenceTechnician evidenceTechUpdated = testRestTemplate.getForObject(baseURL + "/update/" + "5555", EvidenceTechnician.class);
        assertNotNull(evidenceTechUpdated);

    }

    @Test
    public void delete() {

        EvidenceTechnician evidenceTech = testRestTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        assertNotNull(evidenceTech);
        testRestTemplate.delete(baseURL + "/delete/" + "5555");

        try {
            evidenceTech = testRestTemplate.getForObject(baseURL + "/find/" + "5555", EvidenceTechnician.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void getAll() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = testRestTemplate.exchange(baseURL + "/getAll", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }
}