package za.ac.cput.Service;

import za.ac.cput.Domain.Evidence;

import java.util.Set;

public interface EvidenceService extends impService<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
