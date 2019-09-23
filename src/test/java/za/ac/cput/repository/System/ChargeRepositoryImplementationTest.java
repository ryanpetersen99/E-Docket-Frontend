package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.factory.System.ChargeFactory;
import za.ac.cput.repository.implementation.System.ChargeRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class ChargeRepositoryImplementationTest {


    private ChargeRepositoryImplementation chargeRepository;
    private Charge charge;

    @Before
    public void setUp() throws Exception {

        chargeRepository = ChargeRepositoryImplementation.getRepository();
        charge = ChargeFactory.getCharge("test", "5555");
    }

    @Test
    public void getAll() {
        chargeRepository.create(charge);
        assertNotNull(chargeRepository.getChargeSet());
        System.out.println("Get All\n" + chargeRepository.getChargeSet());
    }

    @Test
    public void ChargeCreateTest() throws IOException {
        chargeRepository.create(charge);
        Assert.assertNotNull(chargeRepository.getChargeSet());
        System.out.println("Created\n" + chargeRepository.getChargeSet());
    }

    @Test
    public void update() {

        chargeRepository.create(charge);

        Charge updatedCharge = ChargeFactory.getCharge("testing", "5555");

        chargeRepository.update(updatedCharge);

        Assert.assertNotEquals(charge.getNatureOfCharge(), updatedCharge.getNatureOfCharge());
    }

    @Test
    public void delete() {
        chargeRepository.delete("test");
        assertNull(chargeRepository.read("test"));
        System.out.println("Deleted\n" + chargeRepository.read("test"));
    }
}
