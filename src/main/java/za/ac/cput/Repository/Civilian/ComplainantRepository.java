package za.ac.cput.Repository.Civilian;

import za.ac.cput.Domain.Civilian.Complainant;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ComplainantRepository extends impRepository<Complainant, String> {
    Set<Complainant> getComplainantSet();
}
