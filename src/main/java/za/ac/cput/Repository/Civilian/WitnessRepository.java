package za.ac.cput.Repository.Civilian;

import za.ac.cput.Domain.Civilian.Witness;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface WitnessRepository extends impRepository<Witness, String> {
    Set<Witness> getWitnessSet();
}
