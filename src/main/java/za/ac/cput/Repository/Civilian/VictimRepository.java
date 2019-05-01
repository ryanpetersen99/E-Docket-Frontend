package za.ac.cput.Repository.Civilian;

import za.ac.cput.Domain.Civilian.Victim;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface VictimRepository extends impRepository<Victim, String> {
    Set<Victim> getVictimSet();
}
