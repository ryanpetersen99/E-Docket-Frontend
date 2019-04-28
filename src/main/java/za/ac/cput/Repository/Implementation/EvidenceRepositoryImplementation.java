package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Evidence;
import za.ac.cput.Repository.EvidenceRepository;

import java.util.HashSet;
import java.util.Set;

public class EvidenceRepositoryImplementation implements EvidenceRepository{

    private static EvidenceRepositoryImplementation evidRepImp = null;
    private Set<Evidence> evidenceSet;

    private EvidenceRepositoryImplementation(){
        this.evidenceSet = new HashSet<>();
    }

    public static EvidenceRepositoryImplementation getRepository(){
        if(evidRepImp == null)evidRepImp = new EvidenceRepositoryImplementation();
        return evidRepImp;
    }

    @Override
    public Evidence create(Evidence evidence) {
        this.evidenceSet.add(evidence);
        return evidence;
    }

    @Override
    public Evidence read(String evidenceID) {
        return null;
    }

    @Override
    public Evidence update(Evidence evidence) {
        return evidence;
    }

    @Override
    public void delete(String evidenceID) {

    }

    public Set<Evidence> getEvidenceSet() {
        return this.evidenceSet;
    }
}
