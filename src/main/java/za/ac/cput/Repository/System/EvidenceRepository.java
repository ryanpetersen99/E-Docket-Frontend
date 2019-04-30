package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface EvidenceRepository extends impRepository<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
