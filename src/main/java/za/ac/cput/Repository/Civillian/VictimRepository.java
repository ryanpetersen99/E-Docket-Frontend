package za.ac.cput.Repository.Civillian;

import za.ac.cput.Domain.Civillian.Victim;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface VictimRepository extends impRepository<Victim, String> {
    Set<Victim> getVictimSet();
}
