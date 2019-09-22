package za.ac.cput.repository.Civilian;

import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface WitnessRepository extends impRepository<Witness, String> {
    Set<Witness> getWitnessSet();
}
