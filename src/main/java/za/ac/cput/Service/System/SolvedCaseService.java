package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface SolvedCaseService extends impService<SolvedCase, String> {
    Set<SolvedCase> getSolvedCase();
}
