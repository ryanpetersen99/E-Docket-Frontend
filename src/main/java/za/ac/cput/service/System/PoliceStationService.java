package za.ac.cput.service.System;

import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.service.impService;

import java.util.Set;

public interface PoliceStationService extends impService<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
