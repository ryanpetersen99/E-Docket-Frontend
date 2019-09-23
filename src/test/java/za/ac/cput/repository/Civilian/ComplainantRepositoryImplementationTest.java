package za.ac.cput.repository.Civilian;
//RyanPetersen

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.factory.Civilian.ComplainantFactory;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class ComplainantRepositoryImplementationTest {


    private ComplainantRepositoryImplementation complainantRepository;
    private Complainant complainant;

    @Before
    public void setUp() throws Exception {

        complainantRepository = ComplainantRepositoryImplementation.getRepository();
        complainant = ComplainantFactory.getComplainant("8888", "Ryan", "Petersen", "Fraud");
    }

    @Test
    public void getAll() {
        complainantRepository.create(complainant);
        assertNotNull(complainantRepository.getComplainantSet());
        System.out.println("Get All\n" + complainantRepository.getComplainantSet());
    }

    @Test
    public void ComplainantCreateTest() throws IOException {
        complainantRepository.create(complainant);
        Assert.assertNotNull(complainantRepository.getComplainantSet());
        System.out.println("Created\n" + complainantRepository.getComplainantSet());
    }

    @Test
    public void update() {

        complainantRepository.create(complainant);

        Complainant updatedComplainant = ComplainantFactory.getComplainant("37443", "Ryan", "Petersen", "murder");

        complainantRepository.update(updatedComplainant);

        Assert.assertNotEquals(complainant.getComplainantID(), updatedComplainant.getComplainantID());
    }

    @Test
    public void delete() {
        complainantRepository.delete("37443");
        assertNull(complainantRepository.read("37443"));
        System.out.println("Deleted\n" + complainantRepository.read("37443"));
    }

}
