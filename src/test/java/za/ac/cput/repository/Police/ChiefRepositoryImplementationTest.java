package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.factory.Police.ChiefFactory;
import za.ac.cput.repository.implementation.Police.ChiefRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class ChiefRepositoryImplementationTest {


    private ChiefRepositoryImplementation chiefRepository;
    private Chief chief;

    @Before
    public void setUp() throws Exception {

        chiefRepository = ChiefRepositoryImplementation.getRepository();
        chief = ChiefFactory.getChief("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getAll() {
        chiefRepository.create(chief);
        assertNotNull(chiefRepository.getChiefSet());
        System.out.println("Get All\n" + chiefRepository.getChiefSet());
    }

    @Test
    public void ChiefCreateTest() throws IOException {
        chiefRepository.create(chief);
        Assert.assertNotNull(chiefRepository.getChiefSet());
        System.out.println("Created\n" + chiefRepository.getChiefSet());
    }

    @Test
    public void update() {

        chiefRepository.create(chief);

        Chief updatedChief = ChiefFactory.getChief("37443", "Ryan", "Petersen", "5555");

        chiefRepository.update(updatedChief);

        Assert.assertNotEquals(chief.getChiefID(), updatedChief.getChiefID());
    }

    @Test
    public void delete() {
        chiefRepository.delete("37443");
        assertNull(chiefRepository.read("37443"));
        System.out.println("Deleted\n" + chiefRepository.read("37443"));
    }
}

