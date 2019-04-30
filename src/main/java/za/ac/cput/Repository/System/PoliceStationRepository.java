package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface PoliceStationRepository extends impRepository<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
