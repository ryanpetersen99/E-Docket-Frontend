package za.ac.cput.factory.Police;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.Police.Chief;

/**
 * Unit test for simple App.
 */
public class ChiefFactoryTest {
    @Test

    public void getChief() {

        String id = "43434";
        String name = "Alexis";
        String surname = "Sanchez";
        String badgeID = "7890";

        Chief chief = ChiefFactory.getChief(id, name, surname, badgeID);
        System.out.println(chief);
        Assert.assertNotNull(chief.getChiefID());
        Assert.assertNotNull(chief.getChiefName());
        Assert.assertNotNull(chief.getChiefSurname());
        Assert.assertNotNull(chief.getChiefBadgeID());
    }
}
