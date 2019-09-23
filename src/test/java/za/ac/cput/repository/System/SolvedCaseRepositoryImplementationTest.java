package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.factory.System.SolvedCaseFactory;
import za.ac.cput.repository.implementation.System.SolvedCaseRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class SolvedCaseRepositoryImplementationTest {


    private SolvedCaseRepositoryImplementation solvedCaseRepository;
    private SolvedCase solvedCase;

    @Before
    public void setUp() throws Exception {

        solvedCaseRepository = SolvedCaseRepositoryImplementation.getRepository();
        solvedCase = SolvedCaseFactory.getSolvedCase("8888", "Ryan", 5, "14 May 2010");
    }

    @Test
    public void getAll() {
        solvedCaseRepository.create(solvedCase);
        assertNotNull(solvedCaseRepository.getSolvedCaseSet());
        System.out.println("Get All\n" + solvedCaseRepository.getSolvedCaseSet());
    }

    @Test
    public void SolvedCaseCreateTest() throws IOException {
        solvedCaseRepository.create(solvedCase);
        Assert.assertNotNull(solvedCaseRepository.getSolvedCaseSet());
        System.out.println("Created\n" + solvedCaseRepository.getSolvedCaseSet());
    }

    @Test
    public void update() {

        solvedCaseRepository.create(solvedCase);

        SolvedCase updatedSolvedCase = SolvedCaseFactory.getSolvedCase("37443", "Ryan", 5, "14 may 2010");

        solvedCaseRepository.update(updatedSolvedCase);

        Assert.assertNotEquals(solvedCase.getCaseID(), updatedSolvedCase.getCaseID());
    }

    @Test
    public void delete() {
        solvedCaseRepository.delete("37443");
        assertNull(solvedCaseRepository.read("37443"));
        System.out.println("Deleted\n" + solvedCaseRepository.read("37443"));
    }
}