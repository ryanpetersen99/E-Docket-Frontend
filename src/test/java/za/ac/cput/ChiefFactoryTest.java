package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Charge;
import za.ac.cput.Domain.Chief;
import za.ac.cput.Factory.ChargeFactory;
import za.ac.cput.Factory.ChiefFactory;

/**
 * Unit test for simple App.
 */
public class ChiefFactoryTest
{
    @Test

    public void getChief(){

        String id = "43434";
        String name = "Alexis";
        String surname = "Sanchez";
        String badgeID = "7890";

        Chief chief = ChiefFactory.getChief(id,name,surname,badgeID);
        System.out.println(chief);
        Assert.assertNotNull(chief.getChiefID());
        Assert.assertNotNull(chief.getChiefName());
        Assert.assertNotNull(chief.getChiefSurname());
        Assert.assertNotNull(chief.getChiefBadgeID());
    }
}
