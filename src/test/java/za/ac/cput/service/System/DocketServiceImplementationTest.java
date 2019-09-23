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
import za.ac.cput.domain.System.Docket;
import za.ac.cput.factory.System.DocketFactory;
import za.ac.cput.service.System.implementation.DocketServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class DocketServiceImplementationTest {

    DocketServiceImplementation service;
    Docket dokcet;

    @Before
    public void setUp() throws Exception {
        service = (DocketServiceImplementation) DocketServiceImplementation.getDocketService();
        dokcet = DocketFactory.getDocket("8888");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(dokcet);
        assertNotNull(service.getDocketSet());
        System.out.println("Get All\n" + service.getDocketSet());
    }

    @Test
    public void create() {
        service.create(dokcet);
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
        service.create(dokcet);
        System.out.println(service.read("8888"));

        Docket dokcetUpdated = DocketFactory.getDocket("6666");
        service.update(dokcetUpdated);

        Docket comp = service.read("8888");
        Assert.assertNotEquals(dokcet.getDocketID(), comp.getDocketID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(dokcet.getDocketID()));
        System.out.println("Delete\n" + service.read(dokcet.getDocketID()));
    }

}