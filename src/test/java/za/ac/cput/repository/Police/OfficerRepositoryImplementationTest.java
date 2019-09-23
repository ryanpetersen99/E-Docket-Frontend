package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.factory.Police.OfficerFactory;
import za.ac.cput.factory.Police.OfficerFactory;
import za.ac.cput.repository.implementation.Police.OfficerRepositoryImplementation;
import za.ac.cput.repository.implementation.Police.OfficerRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class OfficerRepositoryImplementationTest {


    private OfficerRepositoryImplementation officerRepository;
    private Officer officer;

    @Before
    public void setUp() throws Exception {

        officerRepository = OfficerRepositoryImplementation.getRepository();
        officer = OfficerFactory.getOfficer("8888", "Ryan", "Petersen","5555");
    }

    @Test
    public void getAll() {
        officerRepository.create(officer);
        assertNotNull(officerRepository.getOfficerSet());
        System.out.println("Get All\n" + officerRepository.getOfficerSet());
    }

    @Test
    public void OfficerCreateTest() throws IOException {
        officerRepository.create(officer);
        Assert.assertNotNull(officerRepository.getOfficerSet());
        System.out.println("Created\n" + officerRepository.getOfficerSet());
    }

    @Test
    public void update() {

        officerRepository.create(officer);

        Officer updatedOfficer = OfficerFactory.getOfficer("37443", "35555", "Petersen","5555");

        officerRepository.update(updatedOfficer);

        Assert.assertNotEquals(officer.getOfficerID(), updatedOfficer.getOfficerID());
    }

    @Test
    public void delete() {
        officerRepository.delete("37443");
        assertNull(officerRepository.read("37443"));
        System.out.println("Deleted\n" + officerRepository.read("37443"));
    }
}