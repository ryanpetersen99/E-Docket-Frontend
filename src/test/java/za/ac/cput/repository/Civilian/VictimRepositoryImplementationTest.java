package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.factory.Civilian.VictimFactory;
import za.ac.cput.repository.implementation.Civillian.VictimRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class VictimRepositoryImplementationTest {


    private VictimRepositoryImplementation victimeRep;
    private Victim victim;

    @Before
    public void setUp() throws Exception {

        victimeRep = VictimRepositoryImplementation.getRepository();
        victim = VictimFactory.getVictim("8888", "Ryan", "Petersen", "Fraud");
    }

    @Test
    public void getAll() {
        victimeRep.create(victim);
        assertNotNull(victimeRep.getVictimSet());
        System.out.println("Get All\n" + victimeRep.getVictimSet());
    }

    @Test
    public void VictimCreateTest() throws IOException {
        victimeRep.create(victim);
        Assert.assertNotNull(victimeRep.getVictimSet());
        System.out.println("Created\n" + victimeRep.getVictimSet());
    }

    @Test
    public void update() {

        victimeRep.create(victim);

        Victim updatedVictim = VictimFactory.getVictim("37443", "Ryan", "Petersen", "murder");

        victimeRep.update(updatedVictim);

        Assert.assertNotEquals(victim.getVictimID(), updatedVictim.getVictimID());
    }

    @Test
    public void delete() {
        victimeRep.delete("37443");
        assertNull(victimeRep.read("37443"));
        System.out.println("Deleted\n" + victimeRep.read("37443"));
    }

}