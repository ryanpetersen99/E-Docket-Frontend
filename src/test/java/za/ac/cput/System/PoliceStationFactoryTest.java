package za.ac.cput.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Factory.System.PoliceStationFactory;

/**
 * Unit test for simple App.
 */
public class PoliceStationFactoryTest
{
    @Test

    public void getPoliceStation(){

        String name = "Woodstock Police Station";
        PoliceStation policeStation = PoliceStationFactory.getPoliceStation(name);
        System.out.println(policeStation);
        Assert.assertNotNull(policeStation.getStationName());
    }
}
