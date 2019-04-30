package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface PendingCaseRepository extends impRepository<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
