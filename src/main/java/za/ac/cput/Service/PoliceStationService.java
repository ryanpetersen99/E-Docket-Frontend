package za.ac.cput.Service;

import za.ac.cput.Domain.PoliceStation;

import java.util.Set;

public interface PoliceStationService extends impService<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
