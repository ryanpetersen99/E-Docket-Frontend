package za.ac.cput.service.Civilian.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.repository.Civilian.VictimRepository;
import za.ac.cput.repository.implementation.Civillian.VictimRepositoryImplementation;
import za.ac.cput.service.Civilian.VictimService;

import java.util.Set;

@Service("VictimServiceImplementation")
public class VictimServiceImplementation implements VictimService {

    private static VictimServiceImplementation victimServiceImplementation = null;
    private VictimRepository victimRepository;

    private VictimServiceImplementation() {
        this.victimRepository = VictimRepositoryImplementation.getRepository();
    }

    public static VictimServiceImplementation getRepository() {
        if (victimServiceImplementation == null) victimServiceImplementation = new VictimServiceImplementation();
        return victimServiceImplementation;
    }

    @Override
    public Victim create(Victim victim) {
        return this.victimRepository.create(victim);
    }

    @Override
    public Victim read(String v) {
        return this.victimRepository.read(v);
    }

    @Override
    public Victim update(Victim victim) {
        return this.victimRepository.update(victim);
    }

    @Override
    public void delete(String v) {
        this.victimRepository.delete(v);
    }

    public Set<Victim> getVictimSet() {
        return this.victimRepository.getVictimSet();
    }
}
