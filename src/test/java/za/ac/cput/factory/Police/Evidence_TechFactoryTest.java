package za.ac.cput.factory.Police;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.Police.EvidenceTechnician;

/**
 * Unit test for simple App.
 */
public class Evidence_TechFactoryTest {
    @Test

    public void getEvidenceTech() {

        String id = "4738553";
        String name = "Alan";
        String surname = "Walker";
        String badgeID = "79238";

        EvidenceTechnician technician = EvidenceTechnicianFactory.getEvidence_Technician(id, name, surname, badgeID);
        System.out.println(technician);
        Assert.assertNotNull(technician.getEvidenceTechID());
        Assert.assertNotNull(technician.getEvidenceTechName());
        Assert.assertNotNull(technician.getEvidenceTechSurname());
        Assert.assertNotNull(technician.getEvidenceTechBadgeID());
    }
}
