package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Witness;
import za.ac.cput.Repository.Implementation.WitnessRepositoryImplementation;
import za.ac.cput.Repository.WitnessRepository;
import za.ac.cput.Service.WitnessService;

import java.util.HashSet;
import java.util.Set;

public class WitnessServiceImplementation implements WitnessService{

    private static WitnessServiceImplementation witnessService = null;
    private WitnessRepository witnessRepository;

    private WitnessServiceImplementation(){ this.witnessRepository = WitnessRepositoryImplementation.getRepository(); }

    public static WitnessServiceImplementation getWitnessService(){
        if(witnessService == null)witnessService = new WitnessServiceImplementation();
        return witnessService;
    }

    @Override
    public Witness create(Witness witness) {return this.create(witness);}

    @Override
    public Witness read(String w) {
        return this.read(w);
    }

    @Override
    public Witness update(Witness witness) {
        return this.update(witness);
    }

    @Override
    public void delete(String w) { this.delete(w);}

    public Set<Witness> getWitnessSet() {
        return this.witnessRepository.getWitnessSet();
    }
}
