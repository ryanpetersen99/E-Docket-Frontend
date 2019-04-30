package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface EvidenceService extends impService<Evidence, String> {
    Set<Evidence> getEvidenceSet();
}
