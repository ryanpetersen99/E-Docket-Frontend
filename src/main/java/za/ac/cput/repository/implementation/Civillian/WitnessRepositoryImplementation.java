package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.repository.Civilian.WitnessRepository;

import java.util.*;

@Repository("WitnessRepository")
public class WitnessRepositoryImplementation implements WitnessRepository {

    private static WitnessRepositoryImplementation compRepImp = null;
    private Map<String, Witness> witnessSet;

    private WitnessRepositoryImplementation() {
        this.witnessSet = new HashMap<>();
    }

    public static WitnessRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new WitnessRepositoryImplementation();
        return compRepImp;
    }

//    private Witness findWitness(String witnessID) {
//        return this.witnessSet.stream()
//                .filter(witness -> witness.getWitnessID().trim().equals(witnessID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Witness create(Witness witness) {
        if (read(witness.getWitnessID()) == null) {
            this.witnessSet.put(witness.getWitnessID(), witness);
        }
        return witness;
    }

    @Override
    public Witness read(String id) {
        return this.witnessSet.get(id);
    }

    @Override
    public Witness update(Witness witness) {
        if (read(witness.getWitnessID()) != null) {
            witnessSet.replace(witness.getWitnessID(), witness);
        }
        return witness;
    }

    @Override
    public void delete(String id) {
        Witness witness = read(id);
        this.witnessSet.remove(id, witness);

    }

    public Set<Witness> getWitnessSet() {
        Collection<Witness> witness = this.witnessSet.values();
        Set<Witness> set = new HashSet<>();
        set.addAll(witness);
        return set;
    }
}