package za.ac.cput.factory.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.System.Docket;

/**
 * Unit test for simple App.
 */
public class DocketFactoryTest {
    @Test

    public void getDocket() {

        String docketID = "14314";
        String date = "May";
        Docket docket = DocketFactory.getDocket(docketID,date);
        System.out.println(docket);
        Assert.assertNotNull(docket.getDocketID());
    }
}
