package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.repository.System.PendingCaseRepository;

import java.util.*;

@Repository("PendingCaseRepository")
public class PendingCaseRepositoryImplementation implements PendingCaseRepository {

    private static PendingCaseRepositoryImplementation compRepImp = null;
    private Map<String, PendingCase> pendingcaseSet;

    private PendingCaseRepositoryImplementation() {
        this.pendingcaseSet = new HashMap<>();
    }

    public static PendingCaseRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new PendingCaseRepositoryImplementation();
        return compRepImp;
    }

//    private PendingCase findPendingCase(String pendingcaseID) {
//        return this.pendingcaseSet.stream()
//                .filter(pendingcase -> pendingcase.getPendingCaseID().trim().equals(pendingcaseID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public PendingCase create(PendingCase pendingcase) {
        if (read(pendingcase.getCaseID()) == null) {
            this.pendingcaseSet.put(pendingcase.getCaseID(), pendingcase);
        }
        return pendingcase;
    }

    @Override
    public PendingCase read(String id) {
        return this.pendingcaseSet.get(id);
    }

    @Override
    public PendingCase update(PendingCase pendingcase) {
        if (read(pendingcase.getCaseID()) != null) {
            pendingcaseSet.replace(pendingcase.getCaseID(), pendingcase);
        }
        return pendingcase;
    }

    @Override
    public void delete(String id) {
        PendingCase pendingcase = read(id);
        this.pendingcaseSet.remove(id, pendingcase);

    }

    public Set<PendingCase> getPendingCaseSet() {
        Collection<PendingCase> pendingcase = this.pendingcaseSet.values();
        Set<PendingCase> set = new HashSet<>();
        set.addAll(pendingcase);
        return set;
    }
}