package za.ac.cput.factory.Police;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.Police.Officer;

/**
 * Unit test for simple App.
 */
public class OfficerFactoryTest {
    @Test

    public void getOfficer() {

        String officerBadgeID = "5000007";
        String officerID = "9504258098092";
        String officerName = "Mohammed";
        String officerSurname = "Salah";

        Officer officer = OfficerFactory.getOfficer(officerBadgeID, officerID, officerName, officerSurname);
        System.out.println(officer);
        Assert.assertNotNull(officer.getOfficerBadgeID());
        Assert.assertNotNull(officer.getOfficerID());
        Assert.assertNotNull(officer.getOfficerName());
        Assert.assertNotNull(officer.getOfficerSurname());
    }
}
