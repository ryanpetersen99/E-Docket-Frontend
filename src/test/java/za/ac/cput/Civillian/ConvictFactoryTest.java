package za.ac.cput.Civillian;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Factory.Civillian.ConvictFactory;

/**
 * Unit test for simple App.
 */
public class ConvictFactoryTest
{
    @Test

    public void getConvict(){

        String id = "9604055079095";
        String name = "Tim";
        String surname = "Alan";
        String conviction = "Committed Forgery";

        Convict convict = ConvictFactory.getConvict(id,name,surname,conviction);
        System.out.println(convict);
        Assert.assertNotNull(convict.getConvictID());
        Assert.assertNotNull(convict.getConvictName());
        Assert.assertNotNull(convict.getConvictSurname());
        Assert.assertNotNull(convict.getNatureOfConviction());
    }
}
