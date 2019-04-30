package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Repository.Implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.Repository.System.PoliceStationRepository;
import za.ac.cput.Service.System.PoliceStationService;

import java.util.Set;

public class PoliceStationServiceImplementation implements PoliceStationService{

    private static PoliceStationServiceImplementation policeStationService = null;
    private PoliceStationRepository policeStationRepository;

    private PoliceStationServiceImplementation(){ this.policeStationRepository = PoliceStationRepositoryImplementation.getRepository(); }

    public static PoliceStationServiceImplementation getPoliceStationService(){
        if(policeStationService == null)policeStationService = new PoliceStationServiceImplementation();
        return policeStationService;
    }

    @Override
    public PoliceStation create(PoliceStation policeStation) { return this.create(policeStation);}

    @Override
    public PoliceStation read(String s) {
        return this.read(s);
    }

    @Override
    public PoliceStation update(PoliceStation policeStation) { return this.update(policeStation); }

    @Override
    public void delete(String s) { this.delete(s);}

    public Set<PoliceStation> getPoliceStationSet() {
        return this.policeStationRepository.getPoliceStationSet();
    }
}
