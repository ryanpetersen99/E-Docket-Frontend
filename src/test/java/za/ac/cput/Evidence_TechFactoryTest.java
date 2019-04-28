package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Convict;
import za.ac.cput.Domain.EvidenceTechnician;
import za.ac.cput.Factory.ConvictFactory;
import za.ac.cput.Factory.EvidenceFactory;
import za.ac.cput.Factory.Evidence_TechnicianFactory;

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
