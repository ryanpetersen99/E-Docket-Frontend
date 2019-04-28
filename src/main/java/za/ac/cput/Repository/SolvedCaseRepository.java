package za.ac.cput.Repository;

import za.ac.cput.Domain.SolvedCase;

import java.util.Set;

public interface SolvedCaseRepository extends impRepository<SolvedCase, String> {
    Set<SolvedCase> getSolvedCaseSet();
}
