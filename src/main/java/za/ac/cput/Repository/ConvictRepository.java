package za.ac.cput.Repository;

import za.ac.cput.Domain.Convict;

import java.util.Set;

public interface ConvictRepository extends impRepository<Convict, String> {
    Set<Convict> getConvictSet();
}
