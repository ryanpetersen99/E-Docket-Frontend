package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.factory.Police.Evidence_TechnicianFactory;
import za.ac.cput.repository.implementation.Police.EvidenceTechnicianRepositoryImplementation;

import java.util.Set;

;


public class EvidenceTechnicianRepositoryImplementationTest {

    private Evidence_TechnicianRepository evidenceTechnicianRepository;
    private EvidenceTechnician evidenceTechnician;
    private EvidenceTechnician evidenceTechnician2;

    public EvidenceTechnician getSavedET() {
        Set<EvidenceTechnician> evidenceTechnicianSet = this.evidenceTechnicianRepository.getEvidenceTechnicianSet();
        return evidenceTechnicianSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.evidenceTechnicianRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
        this.evidenceTechnician = Evidence_TechnicianFactory.getEvidence_Technician("90009", "Deni", "Ali", "8008");
        this.evidenceTechnician2 = Evidence_TechnicianFactory.getEvidence_Technician("90089", "Marus", "Rashford", "7890");
    }

    @Test
    public void create() {
        EvidenceTechnician createdET = this.evidenceTechnicianRepository.create(this.evidenceTechnician);
        EvidenceTechnician createdET2 = this.evidenceTechnicianRepository.create(this.evidenceTechnician2);
        System.out.println("Successfully created Evidence Technician" + "\n" + evidenceTechnician);
        System.out.println("Successfully created Evidence Technician 2" + "\n" + evidenceTechnician2);
        Assert.assertSame(createdET, this.evidenceTechnician);
        Assert.assertSame(createdET2, this.evidenceTechnician2);
    }

    @Test
    public void update() {
        String id = "90010";
        EvidenceTechnician evidenceTechnician = new EvidenceTechnician.Builder().copy(getSavedET()).evidenceTechID(id).build();
        this.evidenceTechnicianRepository.update(evidenceTechnician);
        System.out.println("Updated" + "\n" + evidenceTechnician);
        Assert.assertSame(id, evidenceTechnician.getEvidenceTechID());
    }

    @Test
    public void delete() {
        EvidenceTechnician evidenceTechnicianSaved = getSavedET();
        this.evidenceTechnicianRepository.delete(evidenceTechnicianSaved.getEvidenceTechID());
        getSavedET();
    }

    @Test
    public void read() {
        EvidenceTechnician evidenceTechnicianSaved = getSavedET();
        EvidenceTechnician read = this.evidenceTechnicianRepository.read(evidenceTechnicianSaved.getEvidenceTechID());
        System.out.println("Read" + "\n" + read);
        Assert.assertSame(evidenceTechnicianSaved, read);
    }

    @Test
    public void getETSet() {
        Set<EvidenceTechnician> evidenceTechnicianSet = this.evidenceTechnicianRepository.getEvidenceTechnicianSet();
        System.out.println("List of Evidence Technician" + "\n" + evidenceTechnicianSet);
        Assert.assertEquals(1, evidenceTechnicianSet.size());
    }
}
