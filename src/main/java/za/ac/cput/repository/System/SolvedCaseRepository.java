package za.ac.cput.repository.System;

import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface SolvedCaseRepository extends impRepository<SolvedCase, String> {
    Set<SolvedCase> getSolvedCaseSet();
}
