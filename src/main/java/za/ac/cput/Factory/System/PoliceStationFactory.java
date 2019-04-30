package za.ac.cput.Factory.System;

import za.ac.cput.Domain.System.PoliceStation;

public class PoliceStationFactory {

    public static PoliceStation getPoliceStation(String stationName){
        return new PoliceStation.Builder().stationName(stationName).build();
    }
}
