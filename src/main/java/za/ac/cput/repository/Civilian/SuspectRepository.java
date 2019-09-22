package za.ac.cput.repository.Civilian;

import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface SuspectRepository extends impRepository<Suspect, String> {
    Set<Suspect> getSuspectSet();
}
