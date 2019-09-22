package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.repository.Civilian.WitnessRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("WitnessRepository")
public class WitnessRepositoryImplementation implements WitnessRepository {

    private static WitnessRepositoryImplementation witnessRepImp = null;
    private Set<Witness> witnessSet;

    private WitnessRepositoryImplementation() {
        this.witnessSet = new HashSet<>();
    }


    private Witness findWitness(String witnessID) {
        return this.witnessSet.stream()
                .filter(witness -> witness.getWitnessID().trim().equals(witnessID))
                .findAny()
                .orElse(null);
    }

    public static WitnessRepositoryImplementation getRepository() {
        if (witnessRepImp == null) witnessRepImp = new WitnessRepositoryImplementation();
        return witnessRepImp;
    }

    @Override
    public Witness create(Witness witness) {
        this.witnessSet.add(witness);
        return witness;
    }

    @Override
    public Witness read(String witnessID) {
        return findWitness(witnessID);
    }

    @Override
    public Witness update(Witness witness) {
        Witness delete = findWitness(witness.getWitnessID());
        if (delete != null) {
            this.witnessSet.remove(delete);
            return create(witness);
        }
        return null;
    }

    @Override
    public void delete(String witnessID) {
        Witness witness = findWitness(witnessID);
        if (witness != null) {
            this.witnessSet.remove(witness);
        }
    }

    public Set<Witness> getWitnessSet() {
        return this.witnessSet;
    }
}
