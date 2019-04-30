package za.ac.cput.Repository.Civillian;

import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ConvictRepository extends impRepository<Convict, String> {
    Set<Convict> getConvictSet();
}
