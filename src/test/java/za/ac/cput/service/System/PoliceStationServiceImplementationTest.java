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
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.repository.System.PoliceStationRepository;
import za.ac.cput.repository.implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.service.System.implementation.PoliceStationServiceImplementation;

import java.util.Set;

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
        service = (PoliceStationServiceImplementation) PoliceStationServiceImplementation.getPoliceStationService();
        ps = PoliceStationFactory.getPoliceStation("name");
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
        System.out.println(service.read("8888"));

        PoliceStation psUpdated = PoliceStationFactory.getPoliceStation("differentname");
        service.update(psUpdated);

        PoliceStation comp = service.read("8888");
        Assert.assertNotEquals(ps.getStationName(), comp.getStationName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(ps.getStationName()));
        System.out.println("Delete\n" + service.read(ps.getStationName()));
    }

}