package za.ac.cput.Repository;

import za.ac.cput.Domain.Evidence;

import java.util.Set;

public interface EvidenceRepository extends impRepository<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
