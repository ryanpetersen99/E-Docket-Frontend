package za.ac.cput.ServiceImplementationTests.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Factory.Police.Evidence_TechnicianFactory;
import za.ac.cput.Repository.Implementation.Police.EvidenceTechnicianRepositoryImplementation;
import za.ac.cput.Repository.Police.Evidence_TechnicianRepository;

import java.util.Set;


public class EvidenceTechnicianRepositoryImplementationTest {

    private Evidence_TechnicianRepository evidenceTechnicianRepository;
    private EvidenceTechnician evidenceTechnician;

    public EvidenceTechnician getSavedET() {
        Set<EvidenceTechnician> evidenceTechnicianSet = this.evidenceTechnicianRepository.getEvidenceTechnicianSet();
        return evidenceTechnicianSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.evidenceTechnicianRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
        this.evidenceTechnician = Evidence_TechnicianFactory.getEvidence_Technician("90009","Deni","Ali","8008");
    }

    @Test
    public void create(){
        EvidenceTechnician createdET = this.evidenceTechnicianRepository.create(this.evidenceTechnician);
        System.out.println("Successfully created Evidence Technician" + "\n" + evidenceTechnician);
        Assert.assertSame(createdET,this.evidenceTechnician);
    }

    @Test
    public void update(){
        String id = "90010";
        EvidenceTechnician evidenceTechnician =  new EvidenceTechnician.Builder().copy(getSavedET()).evidenceTechID(id).build();
        System.out.println("Updating" + "\n" + evidenceTechnician );
        EvidenceTechnician updatedID = this.evidenceTechnicianRepository.update(evidenceTechnician);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getEvidenceTechID());
    }

    @Test
    public void delete(){
        EvidenceTechnician evidenceTechnicianSaved = getSavedET();
        this.evidenceTechnicianRepository.delete(evidenceTechnicianSaved.getEvidenceTechID());
    }

    @Test
    public void read(){
        EvidenceTechnician evidenceTechnicianSaved = getSavedET();
        System.out.println("Read Evidence Tech id" + "\n" + evidenceTechnicianSaved.getEvidenceTechID());
        EvidenceTechnician read = this.evidenceTechnicianRepository.read(evidenceTechnicianSaved.getEvidenceTechID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(evidenceTechnicianSaved,read);
    }

    @Test
    public void getConvictSet(){
        Set<EvidenceTechnician> evidenceTechnicianSet = this.evidenceTechnicianRepository.getEvidenceTechnicianSet();
        System.out.println("List of Evidence Technician" + "\n" + evidenceTechnicianSet);
    }
}
