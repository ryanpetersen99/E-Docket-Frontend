package za.ac.cput.Repository;

import za.ac.cput.Domain.Suspect;

import java.util.Set;

public interface SuspectRepository extends impRepository<Suspect, String> {
    Set<Suspect> getSuspectSet();
}
