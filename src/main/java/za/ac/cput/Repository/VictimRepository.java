package za.ac.cput.Repository;

import za.ac.cput.Domain.Victim;

import java.util.Set;

public interface VictimRepository extends impRepository<Victim, String> {
    Set<Victim> getVictimSet();
}
