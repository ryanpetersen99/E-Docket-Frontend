package za.ac.cput.Repository.Civilian;

import za.ac.cput.Domain.Civilian.Suspect;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface SuspectRepository extends impRepository<Suspect, String> {
    Set<Suspect> getSuspectSet();
}
