package za.ac.cput.Repository.Implementation.System;

import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Repository.System.PendingCaseRepository;

import java.util.HashSet;
import java.util.Set;

public class PendingCaseRepositoryImplementation implements PendingCaseRepository {

    private static PendingCaseRepositoryImplementation pendingCaseRepositoryImplementation = null;
    private Set<PendingCase> pendingCaseSet;

    private PendingCaseRepositoryImplementation(){
        this.pendingCaseSet = new HashSet<>();
    }

    private PendingCase findCase(String caseID){
        return  this.pendingCaseSet.stream()
                .filter(pendingCase -> pendingCase.getCaseID().trim().equals(caseID))
                .findAny()
                .orElse(null);
    }

    public static PendingCaseRepositoryImplementation getRepository(){
        if(pendingCaseRepositoryImplementation == null)pendingCaseRepositoryImplementation = new PendingCaseRepositoryImplementation();
        return pendingCaseRepositoryImplementation;
    }

    @Override
    public PendingCase create(PendingCase pendingCase) {
        this.pendingCaseSet.add(pendingCase);
        return pendingCase;
    }

    @Override
    public PendingCase read(String caseID) {
        return findCase(caseID);
    }

    @Override
    public PendingCase update(PendingCase pendingCase) {
        PendingCase delete = findCase(pendingCase.getCaseID());
        if(delete != null){
            this.pendingCaseSet.remove(delete);
            return create(pendingCase);
        }
        return null;
    }

    @Override
    public void delete(String caseID) {
        PendingCase pendingCase = findCase(caseID);
        if(caseID != null) {
            this.pendingCaseSet.remove(pendingCase);
        }
    }

    public Set<PendingCase> getPendingCaseSet() {
        return this.pendingCaseSet;
    }
}
