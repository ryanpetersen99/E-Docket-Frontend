package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Repository.Implementation.System.SolvedCaseRepositoryImplementation;
import za.ac.cput.Repository.System.SolvedCaseRepository;
import za.ac.cput.Service.System.SolvedCaseService;

import java.util.Set;

public class SolvedCaseServiceImplementation implements SolvedCaseService {

    private static SolvedCaseServiceImplementation solvedCaseServiceImplementation = null;
    private SolvedCaseRepository solvedCaseRepository;

    private SolvedCaseServiceImplementation(){
        this.solvedCaseRepository = SolvedCaseRepositoryImplementation.getRepository();
    }

    public static SolvedCaseServiceImplementation getRepository(){
        if(solvedCaseServiceImplementation == null)solvedCaseServiceImplementation = new SolvedCaseServiceImplementation();
        return solvedCaseServiceImplementation;
    }

    @Override
    public SolvedCase create(SolvedCase solvedCase) { return this.solvedCaseRepository.create(solvedCase); }

    @Override
    public SolvedCase read(String c) {
        return this.read(c);
    }

    @Override
    public SolvedCase update(SolvedCase solvedCase) {
        return this.solvedCaseRepository.update(solvedCase);
    }

    @Override
    public void delete(String c) { this.solvedCaseRepository.delete(c);}

    public Set<SolvedCase> getSolvedCase() {
        return this.solvedCaseRepository.getSolvedCaseSet();
    }
}
