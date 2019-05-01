package za.ac.cput.Repository.Civilian;

import za.ac.cput.Domain.Civilian.Convict;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ConvictRepository extends impRepository<Convict, String> {
    Set<Convict> getConvictSet();
}
