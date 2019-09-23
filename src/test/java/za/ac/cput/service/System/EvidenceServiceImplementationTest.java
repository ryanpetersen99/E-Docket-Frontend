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
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.factory.System.EvidenceFactory;
import za.ac.cput.service.System.implementation.EvidenceServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class EvidenceServiceImplementationTest {

    EvidenceServiceImplementation service;
    Evidence evidence;

    @Before
    public void setUp() throws Exception {
        service = EvidenceServiceImplementation.getRepository();
        evidence = EvidenceFactory.getEvidence("8888", "Ryan");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(evidence);
        assertNotNull(service.getEvidenceSet());
        System.out.println("Get All\n" + service.getEvidenceSet());
    }

    @Test
    public void create() {
        service.create(evidence);
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
        service.create(evidence);
        System.out.println(service.read("8888"));

        Evidence evidenceUpdated = EvidenceFactory.getEvidence("5555", "Ryan");
        service.update(evidenceUpdated);

        Evidence comp = service.read("8888");
        Assert.assertNotEquals(evidence.getEvidenceID(), comp.getEvidenceID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(evidence.getEvidenceID()));
        System.out.println("Delete\n" + service.read(evidence.getEvidenceID()));
    }

}