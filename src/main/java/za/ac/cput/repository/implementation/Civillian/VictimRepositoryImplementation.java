package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.repository.Civilian.VictimRepository;

import java.util.*;

@Repository("VictimRepository")
public class VictimRepositoryImplementation implements VictimRepository {

    private static VictimRepositoryImplementation compRepImp = null;
    private Map<String, Victim> victimSet;

    private VictimRepositoryImplementation() {
        this.victimSet = new HashMap<>();
    }

    public static VictimRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new VictimRepositoryImplementation();
        return compRepImp;
    }

//    private Victim findVictim(String victimID) {
//        return this.victimSet.stream()
//                .filter(victim -> victim.getVictimID().trim().equals(victimID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Victim create(Victim victim) {
        if (read(victim.getVictimID()) == null) {
            this.victimSet.put(victim.getVictimID(), victim);
        }
        return victim;
    }

    @Override
    public Victim read(String id) {
        return this.victimSet.get(id);
    }

    @Override
    public Victim update(Victim victim) {
        if (read(victim.getVictimID()) != null) {
            victimSet.replace(victim.getVictimID(), victim);
        }
        return victim;
    }

    @Override
    public void delete(String id) {
        Victim victim = read(id);
        this.victimSet.remove(id, victim);

    }

    public Set<Victim> getVictimSet() {
        Collection<Victim> victim = this.victimSet.values();
        Set<Victim> set = new HashSet<>();
        set.addAll(victim);
        return set;
    }
}