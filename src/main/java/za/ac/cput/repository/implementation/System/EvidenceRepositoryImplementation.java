package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Evidence;
import za.ac.cput.repository.System.EvidenceRepository;

import java.util.*;

@Repository("EvidenceRepository")
public class EvidenceRepositoryImplementation implements EvidenceRepository {

    private static EvidenceRepositoryImplementation compRepImp = null;
    private Map<String, Evidence> evidenceSet;

    private EvidenceRepositoryImplementation() {
        this.evidenceSet = new HashMap<>();
    }

    public static EvidenceRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new EvidenceRepositoryImplementation();
        return compRepImp;
    }

//    private Evidence findEvidence(String evidenceID) {
//        return this.evidenceSet.stream()
//                .filter(evidence -> evidence.getEvidenceID().trim().equals(evidenceID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Evidence create(Evidence evidence) {
        if (read(evidence.getEvidenceID()) == null) {
            this.evidenceSet.put(evidence.getEvidenceID(), evidence);
        }
        return evidence;
    }

    @Override
    public Evidence read(String id) {
        return this.evidenceSet.get(id);
    }

    @Override
    public Evidence update(Evidence evidence) {
        if (read(evidence.getEvidenceID()) != null) {
            evidenceSet.replace(evidence.getEvidenceID(), evidence);
        }
        return evidence;
    }

    @Override
    public void delete(String id) {
        Evidence evidence = read(id);
        this.evidenceSet.remove(id, evidence);

    }

    public Set<Evidence> getEvidenceSet() {
        Collection<Evidence> evidence = this.evidenceSet.values();
        Set<Evidence> set = new HashSet<>();
        set.addAll(evidence);
        return set;
    }
}