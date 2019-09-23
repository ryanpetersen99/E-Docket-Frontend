package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.factory.System.PendingCaseFactory;
import za.ac.cput.repository.implementation.System.PendingCaseRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class PendingCaseRepositoryImplementationTest {


    private PendingCaseRepositoryImplementation pendingCaseRepository;
    private PendingCase pendingCase;

    @Before
    public void setUp() throws Exception {

        pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
        pendingCase = PendingCaseFactory.getPendingCase("8888", "Ryan", 5, "14 May 2010");
    }

    @Test
    public void getAll() {
        pendingCaseRepository.create(pendingCase);
        assertNotNull(pendingCaseRepository.getPendingCaseSet());
        System.out.println("Get All\n" + pendingCaseRepository.getPendingCaseSet());
    }

    @Test
    public void PendingCaseCreateTest() throws IOException {
        pendingCaseRepository.create(pendingCase);
        Assert.assertNotNull(pendingCaseRepository.getPendingCaseSet());
        System.out.println("Created\n" + pendingCaseRepository.getPendingCaseSet());
    }

    @Test
    public void update() {

        pendingCaseRepository.create(pendingCase);

        PendingCase updatedPendingCase = PendingCaseFactory.getPendingCase("37443", "Ryan", 5, "14 may 2010");

        pendingCaseRepository.update(updatedPendingCase);

        Assert.assertNotEquals(pendingCase.getCaseID(), updatedPendingCase.getCaseID());
    }

    @Test
    public void delete() {
        pendingCaseRepository.delete("37443");
        assertNull(pendingCaseRepository.read("37443"));
        System.out.println("Deleted\n" + pendingCaseRepository.read("37443"));
    }
}