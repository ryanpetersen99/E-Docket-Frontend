package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.repository.System.PoliceStationRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("PoliceStationRepository")
public class PoliceStationRepositoryImplementation implements PoliceStationRepository {

    private static PoliceStationRepositoryImplementation policeStationRepositoryImplementation = null;
    private Set<PoliceStation> policeStationSet;

    private PoliceStationRepositoryImplementation() {
        this.policeStationSet = new HashSet<>();
    }

    private PoliceStation findStation(String stationName) {
        return this.policeStationSet.stream()
                .filter(station -> station.getStationName().trim().equals(stationName))
                .findAny()
                .orElse(null);
    }

    public static PoliceStationRepositoryImplementation getRepository() {
        if (policeStationRepositoryImplementation == null)
            policeStationRepositoryImplementation = new PoliceStationRepositoryImplementation();
        return policeStationRepositoryImplementation;
    }

    @Override
    public PoliceStation create(PoliceStation policeStation) {
        this.policeStationSet.add(policeStation);
        return policeStation;
    }

    @Override
    public PoliceStation read(String stationName) {
        return findStation(stationName);
    }

    @Override
    public PoliceStation update(PoliceStation policeStation) {
        PoliceStation delete = findStation(policeStation.getStationName());
        if (delete != null) {
            this.policeStationSet.remove(delete);
            return create(policeStation);
        }
        return null;
    }

    @Override
    public void delete(String stationName) {
        PoliceStation policeStation = findStation(stationName);
        if (policeStation != null) {
            this.policeStationSet.remove(policeStation);
        }
    }

    public Set<PoliceStation> getPoliceStationSet() {
        return this.policeStationSet;
    }
}
