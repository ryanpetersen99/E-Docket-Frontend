package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.SolvedCase;
import za.ac.cput.Repository.SolvedCaseRepository;

import java.util.HashSet;
import java.util.Set;

public class SolvedCaseRepositoryImplementation implements SolvedCaseRepository {

    private static SolvedCaseRepositoryImplementation solvedCaseRepositoryImplementation = null;
    private Set<SolvedCase> solvedCaseSet;

    private SolvedCaseRepositoryImplementation(){
        this.solvedCaseSet = new HashSet<>();
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
        return null;
    }

    @Override
    public SolvedCase update(SolvedCase solvedCase) {
        return solvedCase;
    }

    @Override
    public void delete(String caseID) {

    }

    public Set<SolvedCase> getSolvedCaseSet() {
        return this.solvedCaseSet;
    }
}
