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
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.factory.System.PendingCaseFactory;
import za.ac.cput.service.System.implementation.PendingCaseServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class PendingCaseServiceImplementationTest {

    PendingCaseServiceImplementation service;
    PendingCase pc;

    @Before
    public void setUp() throws Exception {
        service = PendingCaseServiceImplementation.getRepository();
        pc = PendingCaseFactory.getPendingCase("8888", "Ryan", 7, "15 may 2010");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(pc);
        assertNotNull(service.getPendingCaseSet());
        System.out.println("Get All\n" + service.getPendingCaseSet());
    }

    @Test
    public void create() {
        service.create(pc);
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
        service.create(pc);
        System.out.println(service.read("8888"));

        PendingCase pcUpdated = PendingCaseFactory.getPendingCase("5555", "Ryan", 5, "14 may 2010");
        service.update(pcUpdated);

        PendingCase comp = service.read("8888");
        Assert.assertNotEquals(pc.getCaseID(), comp.getCaseID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(pc.getCaseID()));
        System.out.println("Delete\n" + service.read(pc.getCaseID()));
    }

}