package za.ac.cput.Repository.Civillian;

import za.ac.cput.Domain.Civillian.Witness;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface WitnessRepository extends impRepository<Witness, String> {
    Set<Witness> getWitnessSet();
}
