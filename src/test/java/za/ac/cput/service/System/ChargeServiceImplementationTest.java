package za.ac.cput.service.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.factory.System.ChargeFactory;
import za.ac.cput.service.System.implementation.ChargeServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class ChargeServiceImplementationTest {

    ChargeServiceImplementation service;
    Charge charge;

    @Before
    public void setUp() throws Exception {
        service = (ChargeServiceImplementation) ChargeServiceImplementation.getRepository();
        charge = ChargeFactory.getCharge("8888", "12");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(charge);
        assertNotNull(service.getChargeSet());
        System.out.println("Get All\n" + service.getChargeSet());
    }

    @Test
    public void create() {
        service.create(charge);
        assertNotNull(service.read("8888"));
        System.out.println("Created\n" + service.read("8888"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("8888"));
        System.out.println("Read\n" + service.read("8888"));
    }

    @Test
    public void update() {
        service.create(charge);
        System.out.println(service.read("8888"));

        Charge chargeUpdated = ChargeFactory.getCharge("5555", "15");
        service.update(chargeUpdated);

        Charge comp = service.read("8888");
        Assert.assertNotEquals(charge.getNoOfCharges(), comp.getNoOfCharges());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(charge.getNatureOfCharge()));
        System.out.println("Delete\n" + service.read(charge.getNatureOfCharge()));
    }

}