package za.ac.cput.repository.Civilian;

import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface VictimRepository extends impRepository<Victim, String> {
    Set<Victim> getVictimSet();
}
