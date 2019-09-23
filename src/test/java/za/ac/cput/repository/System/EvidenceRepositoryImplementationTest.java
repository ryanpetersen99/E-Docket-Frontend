package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.factory.System.EvidenceFactory;
import za.ac.cput.repository.implementation.System.EvidenceRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class EvidenceRepositoryImplementationTest {


    private EvidenceRepositoryImplementation evidenceRepository;
    private Evidence evidence;

    @Before
    public void setUp() throws Exception {

        evidenceRepository = EvidenceRepositoryImplementation.getRepository();
        evidence = EvidenceFactory.getEvidence("8888", "knife");
    }

    @Test
    public void getAll() {
        evidenceRepository.create(evidence);
        assertNotNull(evidenceRepository.getEvidenceSet());
        System.out.println("Get All\n" + evidenceRepository.getEvidenceSet());
    }

    @Test
    public void EvidenceCreateTest() throws IOException {
        evidenceRepository.create(evidence);
        Assert.assertNotNull(evidenceRepository.getEvidenceSet());
        System.out.println("Created\n" + evidenceRepository.getEvidenceSet());
    }

    @Test
    public void update() {

        evidenceRepository.create(evidence);

        Evidence updatedEvidence = EvidenceFactory.getEvidence("37443", "Gun");

        evidenceRepository.update(updatedEvidence);

        Assert.assertNotEquals(evidence.getEvidenceID(), updatedEvidence.getEvidenceID());
    }

    @Test
    public void delete() {
        evidenceRepository.delete("37443");
        assertNull(evidenceRepository.read("37443"));
        System.out.println("Deleted\n" + evidenceRepository.read("37443"));
    }
}

