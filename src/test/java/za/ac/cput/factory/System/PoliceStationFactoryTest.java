package za.ac.cput.factory.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.System.PoliceStation;

/**
 * Unit test for simple App.
 */
public class PoliceStationFactoryTest {
    @Test

    public void getPoliceStation() {

        String name = "Woodstock Police Station";
        String number = "5555";
        PoliceStation policeStation = PoliceStationFactory.getPoliceStation(name,number);
        System.out.println(policeStation);
        Assert.assertNotNull(policeStation.getStationName());
    }
}
