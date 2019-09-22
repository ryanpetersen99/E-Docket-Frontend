package za.ac.cput.service.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.factory.System.EvidenceFactory;
import za.ac.cput.repository.System.EvidenceRepository;
import za.ac.cput.repository.implementation.System.EvidenceRepositoryImplementation;

import java.util.Set;


public class EvidenceServiceImplementationTest {

    private EvidenceRepository evidenceRepository;
    private Evidence evidence;
    private Evidence evidence2;

    public Evidence getSavedEvidence() {
        Set<Evidence> evidenceSet = this.evidenceRepository.getEvidenceSet();
        return evidenceSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.evidenceRepository = EvidenceRepositoryImplementation.getRepository();
        this.evidence = EvidenceFactory.getEvidence("E1003191", "Gun");
        this.evidence2 = EvidenceFactory.getEvidence("E1003192", "Bullet");
    }

    @Test
    public void create() {
        Evidence createdI = this.evidenceRepository.create(this.evidence);
        Evidence createdI2 = this.evidenceRepository.create(this.evidence2);
        System.out.println("Successfully created Evidence" + "\n" + evidence);
        System.out.println("Successfully created Evidence 2" + "\n" + evidence2);
        Assert.assertSame(createdI, this.evidence);
        Assert.assertSame(createdI2, this.evidence2);
    }

    @Test
    public void update() {
        String id = "E1003193";
        Evidence evidence = new Evidence.Builder().copy(getSavedEvidence()).evidenceID(id).build();
        this.evidenceRepository.update(evidence);
        System.out.println("Updated" + "\n" + evidence);
        Assert.assertSame(id, evidence.getEvidenceID());
    }

    @Test
    public void delete() {
        Evidence evidenceSaved = getSavedEvidence();
        this.evidenceRepository.delete(evidenceSaved.getEvidenceID());
        getEvidenceSet();
    }

    @Test
    public void read() {
        Evidence evidenceSaved = getSavedEvidence();
        Evidence read = this.evidenceRepository.read(evidenceSaved.getEvidenceID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedEvidence(), read);
    }

    @Test
    public void getEvidenceSet() {
        Set<Evidence> evidenceSet = this.evidenceRepository.getEvidenceSet();
        System.out.println("List of Evidence" + "\n" + evidenceSet);
        Assert.assertEquals(1, evidenceSet.size());
    }
}
