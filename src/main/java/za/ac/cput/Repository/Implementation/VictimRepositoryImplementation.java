package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Victim;
import za.ac.cput.Repository.VictimRepository;

import java.util.HashSet;
import java.util.Set;

public class VictimRepositoryImplementation implements VictimRepository{

    private static VictimRepositoryImplementation victimRepositoryImplementation = null;
    private Set<Victim> victimSet;

    private VictimRepositoryImplementation(){
        this.victimSet = new HashSet<>();
    }

    public static VictimRepositoryImplementation getRepository(){
        if(victimRepositoryImplementation == null)victimRepositoryImplementation = new VictimRepositoryImplementation();
        return victimRepositoryImplementation;
    }

    @Override
    public Victim create(Victim victim) {
        this.victimSet.add(victim);
        return victim;
    }

    @Override
    public Victim read(String victimID) {
        return null;
    }

    @Override
    public Victim update(Victim victim) {
        return victim;
    }

    @Override
    public void delete(String victimID) {

    }

    public Set<Victim> getVictimSet() {
        return this.victimSet;
    }
}
