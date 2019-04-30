package za.ac.cput.Repository.Civillian;

import za.ac.cput.Domain.Civillian.Complainant;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ComplainantRepository extends impRepository<Complainant, String> {
    Set<Complainant> getComplainantSet();
}
