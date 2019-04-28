package za.ac.cput.Repository;

import za.ac.cput.Domain.PendingCase;

import java.util.Set;

public interface PendingCaseRepository extends impRepository<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
