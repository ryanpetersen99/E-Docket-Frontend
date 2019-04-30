package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface SolvedCaseRepository extends impRepository<SolvedCase, String> {
    Set<SolvedCase> getSolvedCaseSet();
}
