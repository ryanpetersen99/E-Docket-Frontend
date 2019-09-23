package za.ac.cput.service.System.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.repository.System.PoliceStationRepository;
import za.ac.cput.repository.implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.service.System.PoliceStationService;

import java.util.Set;

@Service("PoliceStationServiceImplementation")
public class PoliceStationServiceImplementation implements PoliceStationService {

    private static PoliceStationServiceImplementation policeStationService = null;
    private PoliceStationRepository policeStationRepository;

    private PoliceStationServiceImplementation() {
        this.policeStationRepository = PoliceStationRepositoryImplementation.getRepository();
    }

    public static PoliceStationServiceImplementation getPoliceStationService() {
        if (policeStationService == null) policeStationService = new PoliceStationServiceImplementation();
        return policeStationService;
    }

    @Override
    public PoliceStation create(PoliceStation policeStation) {
        return this.policeStationRepository.create(policeStation);
    }

    @Override
    public PoliceStation read(String s) {
        return this.policeStationRepository.read(s);
    }

    @Override
    public PoliceStation update(PoliceStation policeStation) {
        return this.policeStationRepository.update(policeStation);
    }

    @Override
    public void delete(String s) {
        this.policeStationRepository.delete(s);
    }

    public Set<PoliceStation> getPoliceStationSet() {
        return this.policeStationRepository.getPoliceStationSet();
    }
}
