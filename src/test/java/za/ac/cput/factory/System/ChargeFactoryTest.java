package za.ac.cput.factory.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.System.Charge;

/**
 * Unit test for simple App.
 */
public class ChargeFactoryTest {
    @Test

    public void getCharge() {

        String natureOfCharge = "Murder,Assault";
        Integer noOfCharges = 2;

        Charge charge = ChargeFactory.getCharge(natureOfCharge, noOfCharges);
        System.out.println(charge);
        Assert.assertNotNull(charge.getNatureOfCharge());
        Assert.assertNotNull(charge.getNoOfCharges());
    }
}
