package za.ac.cput.service.Civilian.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.repository.Civilian.SuspectRepository;
import za.ac.cput.repository.implementation.Civillian.SuspectRepositoryImplementation;
import za.ac.cput.service.Civilian.SuspectService;

import java.util.Set;

@Service("SuspectServiceImplementation")
public class SuspectServiceImplementation implements SuspectService {

    private static SuspectServiceImplementation suspectService = null;
    private SuspectRepository suspectRepository;

    private SuspectServiceImplementation() {
        this.suspectRepository = SuspectRepositoryImplementation.getRepository();
    }

    public static SuspectServiceImplementation getSuspectService() {
        if (suspectService == null) suspectService = new SuspectServiceImplementation();
        return suspectService;
    }

    @Override
    public Suspect create(Suspect suspect) {
        return this.suspectRepository.create(suspect);
    }

    @Override
    public Suspect read(String s) {
        return this.suspectRepository.read(s);
    }

    @Override
    public Suspect update(Suspect suspect) {
        return this.suspectRepository.update(suspect);
    }

    @Override
    public void delete(String s) {
        this.suspectRepository.delete(s);
    }

    public Set<Suspect> getSuspectSet() {
        return this.suspectRepository.getSuspectSet();
    }
}
