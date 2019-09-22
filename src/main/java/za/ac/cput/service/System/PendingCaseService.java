package za.ac.cput.service.System;

import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.service.impService;

import java.util.Set;

public interface PendingCaseService extends impService<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
