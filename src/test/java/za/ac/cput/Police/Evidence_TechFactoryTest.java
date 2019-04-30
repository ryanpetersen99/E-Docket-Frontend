package za.ac.cput.Police;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Factory.Police.Evidence_TechnicianFactory;

/**
 * Unit test for simple App.
 */
public class Evidence_TechFactoryTest
{
    @Test

    public void getEvidenceTech(){

        String id = "4738553";
        String name = "Alan";
        String surname = "Walker";
        String badgeID = "79238";

        EvidenceTechnician technician = Evidence_TechnicianFactory.getEvidence_Technician(id,name,surname,badgeID);
        System.out.println(technician);
        Assert.assertNotNull(technician.getEvidenceTechID());
        Assert.assertNotNull(technician.getEvidenceTechName());
        Assert.assertNotNull(technician.getEvidenceTechSurname());
        Assert.assertNotNull(technician.getEvidenceTechBadgeID());
    }
}
