package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.repository.System.SolvedCaseRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("SolvedCaseRepository")
public class SolvedCaseRepositoryImplementation implements SolvedCaseRepository {

    private static SolvedCaseRepositoryImplementation solvedCaseRepositoryImplementation = null;
    private Set<SolvedCase> solvedCaseSet;

    private SolvedCaseRepositoryImplementation() {
        this.solvedCaseSet = new HashSet<>();
    }

    private SolvedCase findCase(String caseID) {
        return this.solvedCaseSet.stream()
                .filter(solvedCase -> solvedCase.getCaseID().trim().equals(caseID))
                .findAny()
                .orElse(null);
    }

    public static SolvedCaseRepositoryImplementation getRepository() {
        if (solvedCaseRepositoryImplementation == null)
            solvedCaseRepositoryImplementation = new SolvedCaseRepositoryImplementation();
        return solvedCaseRepositoryImplementation;
    }

    @Override
    public SolvedCase create(SolvedCase solvedCase) {
        this.solvedCaseSet.add(solvedCase);
        return solvedCase;
    }

    @Override
    public SolvedCase read(String caseID) {
        return findCase(caseID);
    }

    @Override
    public SolvedCase update(SolvedCase solvedCase) {
        SolvedCase delete = findCase(solvedCase.getCaseID());
        if (delete != null) {
            this.solvedCaseSet.remove(delete);
            return create(solvedCase);
        }
        return null;
    }

    @Override
    public void delete(String caseID) {
        SolvedCase solvedCase = findCase(caseID);
        if (solvedCase != null) {
            this.solvedCaseSet.remove(solvedCase);
        }
    }

    public Set<SolvedCase> getSolvedCaseSet() {
        return this.solvedCaseSet;
    }
}
