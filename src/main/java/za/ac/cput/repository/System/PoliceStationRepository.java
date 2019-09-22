package za.ac.cput.repository.System;

import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface PoliceStationRepository extends impRepository<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
