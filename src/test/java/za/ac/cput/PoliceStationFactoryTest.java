package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Docket;
import za.ac.cput.Domain.PoliceStation;
import za.ac.cput.Factory.DocketFactory;
import za.ac.cput.Factory.PoliceStationFactory;

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
