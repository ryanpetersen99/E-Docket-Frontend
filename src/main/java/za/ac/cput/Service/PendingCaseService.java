package za.ac.cput.Service;

import za.ac.cput.Domain.PendingCase;

import java.util.Set;

public interface PendingCaseService extends impService<PendingCase, String> {
    Set<PendingCase> getPendingCaseSet();
}
