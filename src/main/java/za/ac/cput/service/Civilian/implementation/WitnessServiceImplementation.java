package za.ac.cput.service.Civilian.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.repository.Civilian.WitnessRepository;
import za.ac.cput.repository.implementation.Civillian.WitnessRepositoryImplementation;
import za.ac.cput.service.Civilian.WitnessService;

import java.util.Set;

@Service("WitnessServiceImplementation")
public class WitnessServiceImplementation implements WitnessService {

    private static WitnessServiceImplementation witnessService = null;
    private WitnessRepository witnessRepository;

    private WitnessServiceImplementation() {
        this.witnessRepository = WitnessRepositoryImplementation.getRepository();
    }

    public static WitnessServiceImplementation getWitnessService() {
        if (witnessService == null) witnessService = new WitnessServiceImplementation();
        return witnessService;
    }

    @Override
    public Witness create(Witness witness) {
        return this.witnessRepository.create(witness);
    }

    @Override
    public Witness read(String w) {
        return this.witnessRepository.read(w);
    }

    @Override
    public Witness update(Witness witness) {
        return this.witnessRepository.update(witness);
    }

    @Override
    public void delete(String w) {
        this.witnessRepository.delete(w);
    }

    public Set<Witness> getWitnessSet() {
        return this.witnessRepository.getWitnessSet();
    }
}
