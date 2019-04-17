package za.ac.cput.Factory;

import za.ac.cput.Domain.PoliceStation;

public class PoliceStationFactory {

    public static PoliceStation getPoliceStation(String stationName){
        return new PoliceStation.Builder().stationName(stationName).build();
    }
}
