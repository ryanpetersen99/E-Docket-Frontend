package za.ac.cput.service.System;

import za.ac.cput.domain.System.Evidence;
import za.ac.cput.service.impService;

import java.util.Set;

public interface EvidenceService extends impService<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
