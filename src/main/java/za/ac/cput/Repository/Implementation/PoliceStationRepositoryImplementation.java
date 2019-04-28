package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.PoliceStation;
import za.ac.cput.Repository.PoliceStationRepository;

import java.util.HashSet;
import java.util.Set;

public class PoliceStationRepositoryImplementation implements PoliceStationRepository{

    private static PoliceStationRepositoryImplementation policeStationRepositoryImplementation = null;
    private Set<PoliceStation> policeStationSet;

    private PoliceStationRepositoryImplementation(){
        this.policeStationSet = new HashSet<>();
    }

    public static PoliceStationRepositoryImplementation getRepository(){
        if(policeStationRepositoryImplementation == null)policeStationRepositoryImplementation = new PoliceStationRepositoryImplementation();
        return policeStationRepositoryImplementation;
    }

    @Override
    public PoliceStation create(PoliceStation policeStation) {
        this.policeStationSet.add(policeStation);
        return policeStation;
    }

    @Override
    public PoliceStation read(String stationName) {
        return null;
    }

    @Override
    public PoliceStation update(PoliceStation policeStation) {
        return policeStation;
    }

    @Override
    public void delete(String stationName) {

    }

    public Set<PoliceStation> getPoliceStationSet() {
        return this.policeStationSet;
    }
}
