package za.ac.cput.System;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.System.Docket;
import za.ac.cput.Factory.System.DocketFactory;

/**
 * Unit test for simple App.
 */
public class DocketFactoryTest
{
    @Test

    public void getDocket(){

        String docketID = "14314";
        Docket docket = DocketFactory.getDocket(docketID);
        System.out.println(docket);
        Assert.assertNotNull(docket.getDocketID());
    }
}
