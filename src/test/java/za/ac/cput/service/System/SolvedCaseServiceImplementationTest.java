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
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.factory.System.SolvedCaseFactory;
import za.ac.cput.factory.System.SolvedCaseFactory;
import za.ac.cput.repository.System.SolvedCaseRepository;
import za.ac.cput.repository.implementation.System.SolvedCaseRepositoryImplementation;
import za.ac.cput.service.System.implementation.SolvedCaseServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class SolvedCaseServiceImplementationTest {

    SolvedCaseServiceImplementation service;
    SolvedCase sc;

    @Before
    public void setUp() throws Exception {
        service = (SolvedCaseServiceImplementation) SolvedCaseServiceImplementation.getRepository();
        sc = SolvedCaseFactory.getSolvedCase("8888", "Ryan",7,"15 may 2010");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(sc);
        assertNotNull(service.getSolvedCase());
        System.out.println("Get All\n" + service.getSolvedCase());
    }

    @Test
    public void create() {
        service.create(sc);
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
        service.create(sc);
        System.out.println(service.read("8888"));

        SolvedCase scUpdated = SolvedCaseFactory.getSolvedCase("5555", "Ryan",5,"14 may 2010");
        service.update(scUpdated);

        SolvedCase comp = service.read("8888");
        Assert.assertNotEquals(sc.getCaseID(), comp.getCaseID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(sc.getCaseID()));
        System.out.println("Delete\n" + service.read(sc.getCaseID()));
    }

}