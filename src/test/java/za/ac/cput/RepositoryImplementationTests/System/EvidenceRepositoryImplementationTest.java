package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Repository.System.EvidenceRepository;
import za.ac.cput.Repository.Implementation.System.EvidenceRepositoryImplementation;

import java.util.Set;


public class EvidenceRepositoryImplementationTest {

    private EvidenceRepository evidenceRepository;

    @Before
    public void setUp() throws Exception{
        this.evidenceRepository = EvidenceRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.evidenceRepository.create(null);
        Assert.assertEquals(null,null);
    }

    @Test
    public void update(){

    }

    @Test
    public void delete(){
    }

    @Test
    public void read(){

    }

    @Test
    public void getEvidenceSet(){
        Set<Evidence> evidenceSet = this.evidenceRepository.getEvidenceSet();
        Assert.assertEquals(1,evidenceSet.size());
    }
}
