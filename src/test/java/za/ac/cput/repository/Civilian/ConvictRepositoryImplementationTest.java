package za.ac.cput.repository.Civilian;
//Ryan Petersen 217027806

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.factory.Civilian.ConvictFactory;
import za.ac.cput.repository.implementation.Civillian.ConvictRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class ConvictRepositoryImplementationTest {


    private ConvictRepositoryImplementation convictRep;
    private Convict convict;

    @Before
    public void setUp() throws Exception {

        convictRep = ConvictRepositoryImplementation.getRepository();
        convict = ConvictFactory.getConvict("8888", "Ryan", "Petersen", "Fraud");
    }

    @Test
    public void getAll() {
        convictRep.create(convict);
        assertNotNull(convictRep.getConvictSet());
        System.out.println("Get All\n" + convictRep.getConvictSet());
    }

    @Test
    public void ConvictCreateTest() throws IOException {
        convictRep.create(convict);
        Assert.assertNotNull(convictRep.getConvictSet());
        System.out.println("Created\n" + convictRep.getConvictSet());
    }

    @Test
    public void update() {

        convictRep.create(convict);

        Convict updatedConvict = ConvictFactory.getConvict("37443", "Ryan", "Petersen", "murder");

        convictRep.update(updatedConvict);

        Assert.assertNotEquals(convict.getConvictID(), updatedConvict.getConvictID());
    }

    @Test
    public void delete() {
        convictRep.delete("37443");
        assertNull(convictRep.read("37443"));
        System.out.println("Deleted\n" + convictRep.read("37443"));
    }

}