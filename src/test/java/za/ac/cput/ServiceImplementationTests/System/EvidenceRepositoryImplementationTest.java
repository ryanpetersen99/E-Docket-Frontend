package za.ac.cput.ServiceImplementationTests.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Factory.System.EvidenceFactory;
import za.ac.cput.Repository.Implementation.System.EvidenceRepositoryImplementation;
import za.ac.cput.Repository.System.EvidenceRepository;

import java.util.Set;


public class EvidenceRepositoryImplementationTest {

    private EvidenceRepository evidenceRepository;
    private Evidence evidence;

    public Evidence getSavedEvidence() {
        Set<Evidence> evidenceSet = this.evidenceRepository.getEvidenceSet();
        return evidenceSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.evidenceRepository = EvidenceRepositoryImplementation.getRepository();
        this.evidence = EvidenceFactory.getEvidence("E1003191","Gun");
    }

    @Test
    public void create(){
        Evidence createdI = this.evidenceRepository.create(this.evidence);
        System.out.println("Successfully created Evidence" + "\n" + evidence);
        Assert.assertSame(createdI,this.evidence);
    }

    @Test
    public void update(){
        String id = "E1003193";
        Evidence evidence =  new Evidence.Builder().copy(getSavedEvidence()).evidenceID(id).build();
        System.out.println("Updating" + "\n" + evidence );
        Evidence updatedID = this.evidenceRepository.update(evidence);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getEvidenceID());
    }

    @Test
    public void delete(){
        Evidence evidenceSaved = getSavedEvidence();
        this.evidenceRepository.delete(getSavedEvidence().getEvidenceID());
    }

    @Test
    public void read(){
        Evidence evidenceSaved = getSavedEvidence();
        System.out.println("Read evidence id" + "\n" + getSavedEvidence().getEvidenceID());
        Evidence read = this.evidenceRepository.read(evidenceSaved.getEvidenceID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedEvidence(),read);
    }

    @Test
    public void getEvidenceSet(){
        Set<Evidence> evidenceSet = this.evidenceRepository.getEvidenceSet();
        System.out.println("List of Evidence" + "\n" + evidenceSet);
    }
}
