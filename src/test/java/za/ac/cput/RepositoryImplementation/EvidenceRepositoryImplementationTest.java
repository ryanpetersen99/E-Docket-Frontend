package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Evidence;
import za.ac.cput.Repository.EvidenceRepository;
import za.ac.cput.Repository.Implementation.EvidenceRepositoryImplementation;

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
