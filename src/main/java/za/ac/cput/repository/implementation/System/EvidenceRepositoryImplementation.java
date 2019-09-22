package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.repository.System.EvidenceRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("EvidenceRepository")
public class EvidenceRepositoryImplementation implements EvidenceRepository {

    private static EvidenceRepositoryImplementation evidRepImp = null;
    private Set<Evidence> evidenceSet;

    private EvidenceRepositoryImplementation() {
        this.evidenceSet = new HashSet<>();
    }


    private Evidence findEvidence(String evidenceID) {
        return this.evidenceSet.stream()
                .filter(evidence -> evidence.getEvidenceID().trim().equals(evidenceID))
                .findAny()
                .orElse(null);
    }

    public static EvidenceRepositoryImplementation getRepository() {
        if (evidRepImp == null) evidRepImp = new EvidenceRepositoryImplementation();
        return evidRepImp;
    }

    @Override
    public Evidence create(Evidence evidence) {
        this.evidenceSet.add(evidence);
        return evidence;
    }

    @Override
    public Evidence read(String evidenceID) {
        return findEvidence(evidenceID);
    }

    @Override
    public Evidence update(Evidence evidence) {
        Evidence delete = findEvidence(evidence.getEvidenceID());
        if (delete != null) {
            this.evidenceSet.remove(delete);
            return create(evidence);
        }
        return null;
    }

    @Override
    public void delete(String evidenceID) {
        Evidence evidence = findEvidence(evidenceID);
        if (evidence != null) {
            this.evidenceSet.remove(evidence);
        }
    }

    public Set<Evidence> getEvidenceSet() {
        return this.evidenceSet;
    }
}
