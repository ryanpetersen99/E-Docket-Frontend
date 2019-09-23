package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.repository.System.SolvedCaseRepository;

import java.util.*;

@Repository("SolvedCaseRepository")
public class SolvedCaseRepositoryImplementation implements SolvedCaseRepository {

    private static SolvedCaseRepositoryImplementation compRepImp = null;
    private Map<String, SolvedCase> solvedCaseSet;

    private SolvedCaseRepositoryImplementation() {
        this.solvedCaseSet = new HashMap<>();
    }

    public static SolvedCaseRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new SolvedCaseRepositoryImplementation();
        return compRepImp;
    }

//    private SolvedCase findSolvedCase(String solvedCaseID) {
//        return this.solvedCaseSet.stream()
//                .filter(solvedCase -> solvedCase.getSolvedCaseID().trim().equals(solvedCaseID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public SolvedCase create(SolvedCase solvedCase) {
        if (read(solvedCase.getCaseID()) == null) {
            this.solvedCaseSet.put(solvedCase.getCaseID(), solvedCase);
        }
        return solvedCase;
    }

    @Override
    public SolvedCase read(String id) {
        return this.solvedCaseSet.get(id);
    }

    @Override
    public SolvedCase update(SolvedCase solvedCase) {
        if (read(solvedCase.getCaseID()) != null) {
            solvedCaseSet.replace(solvedCase.getCaseID(), solvedCase);
        }
        return solvedCase;
    }

    @Override
    public void delete(String id) {
        SolvedCase solvedCase = read(id);
        this.solvedCaseSet.remove(id, solvedCase);

    }

    public Set<SolvedCase> getSolvedCaseSet() {
        Collection<SolvedCase> solvedCase = this.solvedCaseSet.values();
        Set<SolvedCase> set = new HashSet<>();
        set.addAll(solvedCase);
        return set;
    }
}