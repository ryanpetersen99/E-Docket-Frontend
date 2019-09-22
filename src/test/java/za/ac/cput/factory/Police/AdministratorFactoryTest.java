package za.ac.cput.factory.Police;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.Police.Administrator;

/**
 * Unit test for simple App.
 */
public class AdministratorFactoryTest {
    @Test

    public void getAdministrator() {

        String adminName = "Umbolo";
        String adminSurname = "Kante";
        String adminID = "5555";
        Administrator administrator = AdministratorFactory.getAdministrator(adminID, adminSurname, adminName);
        System.out.println(administrator);
        Assert.assertNotNull(administrator.getAdminID());
        Assert.assertNotNull(administrator.getAdminName());
        Assert.assertNotNull(administrator.getAdminSurname());
    }
}
