package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.PendingCase;
import za.ac.cput.Repository.PendingCaseRepository;

import java.util.HashSet;
import java.util.Set;

public class PendingCaseRepositoryImplementation implements PendingCaseRepository {

    private static PendingCaseRepositoryImplementation pendingCaseRepositoryImplementation = null;
    private Set<PendingCase> pendingCaseSet;

    private PendingCaseRepositoryImplementation(){
        this.pendingCaseSet = new HashSet<>();
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
        return null;
    }

    @Override
    public PendingCase update(PendingCase pendingCase) {
        return pendingCase;
    }

    @Override
    public void delete(String caseID) {

    }

    public Set<PendingCase> getPendingCaseSet() {
        return this.pendingCaseSet;
    }
}
