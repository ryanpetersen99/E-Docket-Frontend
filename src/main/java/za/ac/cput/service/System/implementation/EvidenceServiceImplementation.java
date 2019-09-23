package za.ac.cput.service.System.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.repository.System.EvidenceRepository;
import za.ac.cput.repository.implementation.System.EvidenceRepositoryImplementation;
import za.ac.cput.service.System.EvidenceService;

import java.util.Set;

@Service("EvidenceServiceImplementation")
public class EvidenceServiceImplementation implements EvidenceService {

    private static EvidenceServiceImplementation evidenceService = null;
    private EvidenceRepository evidenceRepository;

    private EvidenceServiceImplementation() {
        this.evidenceRepository = EvidenceRepositoryImplementation.getRepository();
    }

    public static EvidenceServiceImplementation getRepository() {
        if (evidenceService == null) evidenceService = new EvidenceServiceImplementation();
        return evidenceService;
    }

    @Override
    public Evidence create(Evidence evidence) {
        return this.evidenceRepository.create(evidence);
    }

    @Override
    public Evidence read(String e) {
        return this.evidenceRepository.read(e);
    }

    @Override
    public Evidence update(Evidence evidence) {
        return this.evidenceRepository.update(evidence);
    }

    @Override
    public void delete(String e) {
        this.evidenceRepository.delete(e);
    }

    public Set<Evidence> getEvidenceSet() {
        return this.evidenceRepository.getEvidenceSet();
    }
}
