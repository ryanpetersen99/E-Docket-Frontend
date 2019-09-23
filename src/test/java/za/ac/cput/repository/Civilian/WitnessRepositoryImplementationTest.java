package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.factory.Civilian.WitnessFactory;
import za.ac.cput.factory.Civilian.WitnessFactory;
import za.ac.cput.repository.implementation.Civillian.WitnessRepositoryImplementation;
import za.ac.cput.repository.implementation.Civillian.WitnessRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class WitnessRepositoryImplementationTest {


    private WitnessRepositoryImplementation witnessRepository;
    private Witness witness;

    @Before
    public void setUp() throws Exception {

        witnessRepository = WitnessRepositoryImplementation.getRepository();
        witness = WitnessFactory.getWitness("8888", "Ryan", "Petersen","Fraud");
    }

    @Test
    public void getAll() {
        witnessRepository.create(witness);
        assertNotNull(witnessRepository.getWitnessSet());
        System.out.println("Get All\n" + witnessRepository.getWitnessSet());
    }

    @Test
    public void WitnessCreateTest() throws IOException {
        witnessRepository.create(witness);
        Assert.assertNotNull(witnessRepository.getWitnessSet());
        System.out.println("Created\n" + witnessRepository.getWitnessSet() );
    }

    @Test
    public void update() {

        witnessRepository.create(witness);

        Witness updatedWitness = WitnessFactory.getWitness("37443", "Ryan", "Petersen","murder");

        witnessRepository.update(updatedWitness);

        Assert.assertNotEquals(witness.getWitnessID(), updatedWitness.getWitnessID());
    }

    @Test
    public void delete() {
        witnessRepository.delete("37443");
        assertNull(witnessRepository.read("37443"));
        System.out.println("Deleted\n" + witnessRepository.read("37443"));
    }

}