package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.factory.Police.Evidence_TechnicianFactory;
import za.ac.cput.repository.implementation.Police.EvidenceTechnicianRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class EvidenceTechnicianRepositoryImplementationTest {


    private EvidenceTechnicianRepositoryImplementation etRepository;
    private EvidenceTechnician et;

    @Before
    public void setUp() throws Exception {

        etRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
        et = Evidence_TechnicianFactory.getEvidence_Technician("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getAll() {
        etRepository.create(et);
        assertNotNull(etRepository.getEvidenceTechnicianSet());
        System.out.println("Get All\n" + etRepository.getEvidenceTechnicianSet());
    }

    @Test
    public void EvidenceTechnicianCreateTest() throws IOException {
        etRepository.create(et);
        Assert.assertNotNull(etRepository.getEvidenceTechnicianSet());
        System.out.println("Created\n" + etRepository.getEvidenceTechnicianSet());
    }

//    @Test
//    public void update() {
//
//        etRepository.create(et);
//
//        EvidenceTechnician updatedEvidenceTechnician = Evidence_TechnicianFactory.getEvidence_Technician("37443", "Ryan", "Petersen","5555");
//
//        etRepository.update(updatedEvidenceTechnician);
//
//        Assert.assertNotEquals(et.getEvidenceTechID(), updatedEvidenceTechnician.getEvidenceTechID());
//    }

//    @Test
//    public void delete() {
//        etRepository.delete("37443");
//        assertNull(etRepository.read("37443"));
//        System.out.println("Deleted\n" + etRepository.read("37443"));
//    }

}