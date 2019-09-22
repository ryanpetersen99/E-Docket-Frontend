package za.ac.cput.repository.System;

import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface PendingCaseRepository extends impRepository<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
