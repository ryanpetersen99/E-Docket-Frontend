package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Administrator;
import za.ac.cput.Domain.Charge;
import za.ac.cput.Factory.AdministratorFactory;
import za.ac.cput.Factory.ChargeFactory;

/**
 * Unit test for simple App.
 */
public class ChargeFactoryTest
{
    @Test

    public void getCharge(){

        String natureOfCharge = "Murder,Assault";
        Integer noOfCharges = 2;

        Charge charge = ChargeFactory.getCharge(natureOfCharge,noOfCharges);
        System.out.println(charge);
        Assert.assertNotNull(charge.getNatureOfCharge());
        Assert.assertNotNull(charge.getNoOfCharges());
    }
}
