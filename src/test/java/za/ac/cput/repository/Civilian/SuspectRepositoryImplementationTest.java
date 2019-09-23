package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.factory.Civilian.SuspectFactory;
import za.ac.cput.factory.Civilian.SuspectFactory;
import za.ac.cput.repository.implementation.Civillian.SuspectRepositoryImplementation;
import za.ac.cput.repository.implementation.Civillian.SuspectRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class SuspectRepositoryImplementationTest {


    private SuspectRepositoryImplementation suspectRepository;
    private Suspect suspect;

    @Before
    public void setUp() throws Exception {

        suspectRepository = SuspectRepositoryImplementation.getRepository();
        suspect = SuspectFactory.getSuspect("8888", "Ryan", "Petersen","Fraud");
    }

    @Test
    public void getAll() {
        suspectRepository.create(suspect);
        assertNotNull(suspectRepository.getSuspectSet());
        System.out.println("Get All\n" + suspectRepository.getSuspectSet());
    }

    @Test
    public void SuspectCreateTest() throws IOException {
        suspectRepository.create(suspect);
        Assert.assertNotNull(suspectRepository.getSuspectSet());
        System.out.println("Created\n" + suspectRepository.getSuspectSet() );
    }

    @Test
    public void update() {

        suspectRepository.create(suspect);

        Suspect updatedSuspect = SuspectFactory.getSuspect("37443", "Ryan", "Petersen","murder");

        suspectRepository.update(updatedSuspect);

        Assert.assertNotEquals(suspect.getSuspectID(), updatedSuspect.getSuspectID());
    }

    @Test
    public void delete() {
        suspectRepository.delete("37443");
        assertNull(suspectRepository.read("37443"));
        System.out.println("Deleted\n" + suspectRepository.read("37443"));
    }

}