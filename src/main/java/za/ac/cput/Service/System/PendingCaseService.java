package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface PendingCaseService extends impService<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
