package za.ac.cput.repository.Civilian;

import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface ComplainantRepository extends impRepository<Complainant, String> {
    Set<Complainant> getComplainantSet();
}
