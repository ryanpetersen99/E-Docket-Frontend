package za.ac.cput.Service;

import za.ac.cput.Domain.SolvedCase;

import java.util.Set;

public interface SolvedCaseService extends impService<SolvedCase, String> {
    Set<SolvedCase> getSolvedCase();
}
