package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Witness;
import za.ac.cput.Repository.WitnessRepository;

import java.util.HashSet;
import java.util.Set;

public class WitnessRepositoryImplementation implements WitnessRepository{

    private static WitnessRepositoryImplementation witnessRepImp = null;
    private Set<Witness> witnessSet;

    private WitnessRepositoryImplementation(){
        this.witnessSet = new HashSet<>();
    }

    public static WitnessRepositoryImplementation getRepository(){
        if(witnessRepImp == null)witnessRepImp = new WitnessRepositoryImplementation();
        return witnessRepImp;
    }

    @Override
    public Witness create(Witness witness) {
        this.witnessSet.add(witness);
        return witness;
    }

    @Override
    public Witness read(String witnessID) {
        return null;
    }

    @Override
    public Witness update(Witness witness) {
        return witness;
    }

    @Override
    public void delete(String witnessID) {

    }

    public Set<Witness> getWitnessSet() {
        return this.witnessSet;
    }
}
