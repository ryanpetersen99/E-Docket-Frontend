package za.ac.cput.service.System.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.SolvedCase;
import za.ac.cput.repository.System.SolvedCaseRepository;
import za.ac.cput.repository.implementation.System.SolvedCaseRepositoryImplementation;
import za.ac.cput.service.System.SolvedCaseService;

import java.util.Set;

@Service("SolvedCaseServiceImplementation")
public class SolvedCaseServiceImplementation implements SolvedCaseService {

    private static SolvedCaseServiceImplementation solvedCaseServiceImplementation = null;
    private SolvedCaseRepository solvedCaseRepository;

    private SolvedCaseServiceImplementation() {
        this.solvedCaseRepository = SolvedCaseRepositoryImplementation.getRepository();
    }

    public static SolvedCaseServiceImplementation getRepository() {
        if (solvedCaseServiceImplementation == null)
            solvedCaseServiceImplementation = new SolvedCaseServiceImplementation();
        return solvedCaseServiceImplementation;
    }

    @Override
    public SolvedCase create(SolvedCase solvedCase) {
        return this.solvedCaseRepository.create(solvedCase);
    }

    @Override
    public SolvedCase read(String c) {
        return this.solvedCaseRepository.read(c);
    }

    @Override
    public SolvedCase update(SolvedCase solvedCase) {
        return this.solvedCaseRepository.update(solvedCase);
    }

    @Override
    public void delete(String c) {
        this.solvedCaseRepository.delete(c);
    }

    public Set<SolvedCase> getSolvedCase() {
        return this.solvedCaseRepository.getSolvedCaseSet();
    }
}
