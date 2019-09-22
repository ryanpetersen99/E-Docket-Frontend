package za.ac.cput.repository.System;

import za.ac.cput.domain.System.Evidence;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface EvidenceRepository extends impRepository<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
