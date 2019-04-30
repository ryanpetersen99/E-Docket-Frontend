package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Repository.System.EvidenceRepository;
import za.ac.cput.Repository.Implementation.System.EvidenceRepositoryImplementation;
import za.ac.cput.Service.System.EvidenceService;

import java.util.Set;

public class EvidenceServiceImplementation implements EvidenceService{

    private static EvidenceServiceImplementation evidenceService = null;
    private EvidenceRepository evidenceRepository;

    private EvidenceServiceImplementation(){ this.evidenceRepository = EvidenceRepositoryImplementation.getRepository(); }

    public static EvidenceServiceImplementation getRepository(){
        if(evidenceService == null)evidenceService = new EvidenceServiceImplementation();
        return evidenceService;
    }

    @Override
    public Evidence create(Evidence evidence) {return this.create(evidence);}

    @Override
    public Evidence read(String e) {
        return this.read(e);
    }

    @Override
    public Evidence update(Evidence evidence) {
        return this.update(evidence);
    }

    @Override
    public void delete(String e) { this.delete(e);}

    public Set<Evidence> getEvidenceSet() {
        return this.evidenceRepository.getEvidenceSet();
    }
}
