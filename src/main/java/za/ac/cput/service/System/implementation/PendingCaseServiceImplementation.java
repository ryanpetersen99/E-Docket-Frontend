package za.ac.cput.service.System.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.PendingCase;
import za.ac.cput.repository.System.PendingCaseRepository;
import za.ac.cput.repository.implementation.System.PendingCaseRepositoryImplementation;
import za.ac.cput.service.System.PendingCaseService;

import java.util.Set;

@Service("PendingCaseServiceImplementation")
public class PendingCaseServiceImplementation implements PendingCaseService {

    private static PendingCaseServiceImplementation pendingCaseServiceImplementation = null;
    private PendingCaseRepository pendingCaseRepository;

    private PendingCaseServiceImplementation() {
        this.pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
    }

    public static PendingCaseServiceImplementation getRepository() {
        if (pendingCaseServiceImplementation == null)
            pendingCaseServiceImplementation = new PendingCaseServiceImplementation();
        return pendingCaseServiceImplementation;
    }

    @Override
    public PendingCase create(PendingCase pendingCase) {
        return this.pendingCaseRepository.create(pendingCase);
    }

    @Override
    public PendingCase read(String c) {
        return this.pendingCaseRepository.read(c);
    }

    @Override
    public PendingCase update(PendingCase pendingCase) {
        return this.pendingCaseRepository.update(pendingCase);
    }

    @Override
    public void delete(String c) {
        this.delete(c);
    }

    public Set<PendingCase> getPendingCaseSet() {
        return this.pendingCaseRepository.getPendingCaseSet();
    }
}
