package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface PoliceStationService extends impService<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
