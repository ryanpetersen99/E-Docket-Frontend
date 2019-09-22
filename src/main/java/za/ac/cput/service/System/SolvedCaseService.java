package za.ac.cput.service.System;

import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.service.impService;

import java.util.Set;

public interface SolvedCaseService extends impService<SolvedCase, String> {
    Set<SolvedCase> getSolvedCase();
}
