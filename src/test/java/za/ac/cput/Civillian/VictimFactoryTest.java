package za.ac.cput.Civillian;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Civillian.Victim;
import za.ac.cput.Factory.Civillian.VictimFactory;

/**
 * Unit test for simple App.
 */
public class VictimFactoryTest
{
    @Test

    public void getVictim(){

        String ID = "9410100983456";
        String Name = "Naby";
        String Surname = "Kate";
        String Statement = "Got killed in a road rage incident";

        Victim victim = VictimFactory.getVictim(ID,Name,Surname,Statement);
        System.out.println(victim);
        Assert.assertNotNull(victim.getVictimID());
        Assert.assertNotNull(victim.getVictimName());
        Assert.assertNotNull(victim.getVictimSurname());
        Assert.assertNotNull(victim.getStatement());
    }
}
