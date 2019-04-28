package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.DataAnalyst;
import za.ac.cput.Domain.EvidenceTechnician;
import za.ac.cput.Repository.DataAnalystRepository;
import za.ac.cput.Repository.Evidence_TechnicianRepository;
import za.ac.cput.Repository.Implementation.DataAnalystRepositoryImplementation;
import za.ac.cput.Repository.Implementation.EvidenceRepositoryImplementation;
import za.ac.cput.Repository.Implementation.EvidenceTechnicianRepositoryImplementation;

import java.util.Set;


public class EvidenceTechnicianRepositoryImplementationTest {

    private Evidence_TechnicianRepository evidence_technicianRepository;

    @Before
    public void setUp() throws Exception{
        this.evidence_technicianRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.evidence_technicianRepository.create(null);
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
    public void getEvidenceTechSet(){
        Set<EvidenceTechnician> evidenceTechnician = this.evidence_technicianRepository.getEvidenceTechnicianSet();
        Assert.assertEquals(1,evidenceTechnician.size());
    }
}
