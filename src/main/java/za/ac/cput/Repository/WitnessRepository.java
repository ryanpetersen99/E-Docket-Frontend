package za.ac.cput.Repository;

import za.ac.cput.Domain.Witness;

import java.util.Set;

public interface WitnessRepository extends impRepository<Witness, String> {
    Set<Witness> getWitnessSet();
}
