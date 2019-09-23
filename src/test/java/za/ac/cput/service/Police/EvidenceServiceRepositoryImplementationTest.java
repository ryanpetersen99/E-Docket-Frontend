package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.factory.Police.EvidenceTechnicianFactory;
import za.ac.cput.service.Police.implementation.EvidenceTechnicianServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class EvidenceServiceRepositoryImplementationTest {

    EvidenceTechnicianServiceImplementation service;
    EvidenceTechnician evidence;

    @Before
    public void setUp() throws Exception {
        service = EvidenceTechnicianServiceImplementation.getETService();
        evidence = EvidenceTechnicianFactory.getEvidence_Technician("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(evidence);
        assertNotNull(service.getEvidenceTechnicianSet());
        System.out.println("Get All\n" + service.getEvidenceTechnicianSet());
    }

    @Test
    public void create() {
        service.create(evidence);
        assertNotNull(service.read("8888"));
        System.out.println("Created\n" + service.read("8888"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("8888"));
        System.out.println("Read\n" + service.read("8888"));
    }

    @Test
    public void update() {
        service.create(evidence);
        System.out.println(service.read("8888"));

        EvidenceTechnician evidenceUpdated = EvidenceTechnicianFactory.getEvidence_Technician("8888", "Ryaaan", "Petersen", "5555");
        service.update(evidenceUpdated);

        EvidenceTechnician comp = service.read("8888");
        Assert.assertNotEquals(evidence.getEvidenceTechName(), comp.getEvidenceTechName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(evidence.getEvidenceTechID()));
        System.out.println("Delete\n" + service.read(evidence.getEvidenceTechID()));
    }

}