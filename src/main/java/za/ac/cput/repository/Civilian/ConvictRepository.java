package za.ac.cput.repository.Civilian;

import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface ConvictRepository extends impRepository<Convict, String> {
    Set<Convict> getConvictSet();
}
