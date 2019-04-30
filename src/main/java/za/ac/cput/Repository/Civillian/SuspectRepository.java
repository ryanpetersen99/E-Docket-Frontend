package za.ac.cput.Repository.Civillian;

import za.ac.cput.Domain.Civillian.Suspect;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface SuspectRepository extends impRepository<Suspect, String> {
    Set<Suspect> getSuspectSet();
}
