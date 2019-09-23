package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.repository.System.PoliceStationRepository;

import java.util.*;

@Repository("PoliceStationRepository")
public class PoliceStationRepositoryImplementation implements PoliceStationRepository {

    private static PoliceStationRepositoryImplementation compRepImp = null;
    private Map<String, PoliceStation> policeStationSet;

    private PoliceStationRepositoryImplementation() {
        this.policeStationSet = new HashMap<>();
    }

    public static PoliceStationRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new PoliceStationRepositoryImplementation();
        return compRepImp;
    }

//    private PoliceStation findPoliceStation(String policeStationID) {
//        return this.policeStationSet.stream()
//                .filter(policeStation -> policeStation.getPoliceStationID().trim().equals(policeStationID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public PoliceStation create(PoliceStation policeStation) {
        if (read(policeStation.getStationName()) == null) {
            this.policeStationSet.put(policeStation.getStationName(), policeStation);
        }
        return policeStation;
    }

    @Override
    public PoliceStation read(String id) {
        return this.policeStationSet.get(id);
    }

    @Override
    public PoliceStation update(PoliceStation policeStation) {
        if (read(policeStation.getStationName()) != null) {
            policeStationSet.replace(policeStation.getStationName(), policeStation);
        }
        return policeStation;
    }

    @Override
    public void delete(String id) {
        PoliceStation policeStation = read(id);
        this.policeStationSet.remove(id, policeStation);

    }

    public Set<PoliceStation> getPoliceStationSet() {
        Collection<PoliceStation> policeStation = this.policeStationSet.values();
        Set<PoliceStation> set = new HashSet<>();
        set.addAll(policeStation);
        return set;
    }
}