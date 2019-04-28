package za.ac.cput.Repository;

import za.ac.cput.Domain.Complainant;

import java.util.Set;

public interface ComplainantRepository extends impRepository<Complainant, String> {
    Set<Complainant> getComplainantSet();
}
