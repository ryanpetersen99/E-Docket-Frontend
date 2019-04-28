package za.ac.cput.Repository;

import za.ac.cput.Domain.PoliceStation;

import java.util.Set;

public interface PoliceStationRepository extends impRepository<PoliceStation, String> {
    Set<PoliceStation> getPoliceStationSet();
}
