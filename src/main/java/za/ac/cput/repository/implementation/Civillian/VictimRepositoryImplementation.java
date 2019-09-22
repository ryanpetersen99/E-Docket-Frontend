package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.repository.Civilian.VictimRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("VictimRepository")
public class VictimRepositoryImplementation implements VictimRepository {

    private static VictimRepositoryImplementation victimRepositoryImplementation = null;
    private Set<Victim> victimSet;

    private VictimRepositoryImplementation() {
        this.victimSet = new HashSet<>();
    }


    private Victim findVictim(String victimID) {
        return this.victimSet.stream()
                .filter(victim -> victim.getVictimID().trim().equals(victimID))
                .findAny()
                .orElse(null);
    }

    public static VictimRepositoryImplementation getRepository() {
        if (victimRepositoryImplementation == null)
            victimRepositoryImplementation = new VictimRepositoryImplementation();
        return victimRepositoryImplementation;
    }

    @Override
    public Victim create(Victim victim) {
        this.victimSet.add(victim);
        return victim;
    }

    @Override
    public Victim read(String victimID) {
        return findVictim(victimID);
    }

    @Override
    public Victim update(Victim victim) {
        Victim delete = findVictim(victim.getVictimID());
        if (delete != null) {
            this.victimSet.remove(delete);
            return create(victim);
        }
        return null;
    }

    @Override
    public void delete(String victimID) {
        Victim victim = findVictim(victimID);
        if (victim != null) {
            this.victimSet.remove(victim);
        }
    }

    public Set<Victim> getVictimSet() {
        return this.victimSet;
    }
}
