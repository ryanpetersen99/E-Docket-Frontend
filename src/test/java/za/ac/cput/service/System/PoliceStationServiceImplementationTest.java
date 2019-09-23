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
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.service.System.implementation.PoliceStationServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class PoliceStationServiceImplementationTest {

    PoliceStationServiceImplementation service;
    PoliceStation ps;

    @Before
    public void setUp() throws Exception {
        service = PoliceStationServiceImplementation.getPoliceStationService();
        ps = PoliceStationFactory.getPoliceStation("name","5555");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(ps);
        assertNotNull(service.getPoliceStationSet());
        System.out.println("Get All\n" + service.getPoliceStationSet());
    }

    @Test
    public void create() {
        service.create(ps);
        assertNotNull(service.read("name"));
        System.out.println("Created\n" + service.read("name"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("name"));
        System.out.println("Read\n" + service.read("name"));
    }

    @Test
    public void update() {
        service.create(ps);
        System.out.println(service.read("name"));

        PoliceStation psUpdated = PoliceStationFactory.getPoliceStation("name","6666");
        service.update(psUpdated);

        PoliceStation comp = service.read("name");
        Assert.assertNotEquals(ps.getStationNum(), comp.getStationNum());
        System.out.println("Updated\n" + service.read("name"));
    }

    @Test
    public void delete() {
        service.delete("name");
        assertNull(service.read(ps.getStationName()));
        System.out.println("Delete\n" + service.read(ps.getStationName()));
    }

}