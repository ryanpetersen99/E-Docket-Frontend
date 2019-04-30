package za.ac.cput.Repository.Implementation.System;

import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Repository.System.SolvedCaseRepository;

import java.util.HashSet;
import java.util.Set;

public class SolvedCaseRepositoryImplementation implements SolvedCaseRepository {

    private static SolvedCaseRepositoryImplementation solvedCaseRepositoryImplementation = null;
    private Set<SolvedCase> solvedCaseSet;

    private SolvedCaseRepositoryImplementation(){
        this.solvedCaseSet = new HashSet<>();
    }

    private SolvedCase findCase(String caseID){
        return  this.solvedCaseSet.stream()
                .filter(solvedCase -> solvedCase.getCaseID().trim().equals(caseID))
                .findAny()
                .orElse(null);
    }

    public static SolvedCaseRepositoryImplementation getRepository(){
        if(solvedCaseRepositoryImplementation == null)solvedCaseRepositoryImplementation = new SolvedCaseRepositoryImplementation();
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
        if(delete != null){
            this.solvedCaseSet.remove(delete);
            return create(solvedCase);
        }
        return null;
    }

    @Override
    public void delete(String caseID) {
        SolvedCase solvedCase = findCase(caseID);
        if(solvedCase != null) {
            this.solvedCaseSet.remove(solvedCase);
        }
    }

    public Set<SolvedCase> getSolvedCaseSet() {
        return this.solvedCaseSet;
    }
}
