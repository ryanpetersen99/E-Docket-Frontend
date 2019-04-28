package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.EvidenceTechnician;
import za.ac.cput.Repository.EvidenceRepository;
import za.ac.cput.Repository.Evidence_TechnicianRepository;

import java.util.HashSet;
import java.util.Set;

public class EvidenceTechnicianRepositoryImplementation implements Evidence_TechnicianRepository{

    private static EvidenceTechnicianRepositoryImplementation evidenceTechnicianRepositoryImplementation = null;
    private Set<EvidenceTechnician> evidence_technicianSet;

    private EvidenceTechnicianRepositoryImplementation(){
        this.evidence_technicianSet = new HashSet<>();
    }

    public static EvidenceTechnicianRepositoryImplementation getRepository(){
        if(evidenceTechnicianRepositoryImplementation == null)evidenceTechnicianRepositoryImplementation = new EvidenceTechnicianRepositoryImplementation();
        return evidenceTechnicianRepositoryImplementation;
    }

    @Override
    public EvidenceTechnician create(EvidenceTechnician evidenceTechnician) {
        this.evidence_technicianSet.add(evidenceTechnician);
        return evidenceTechnician;
    }

    @Override
    public EvidenceTechnician read(String evidTechID) {
        return null;
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician evidenceTechnician) {
        return evidenceTechnician;
    }

    @Override
    public void delete(String evidTechID) {

    }

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        return this.evidence_technicianSet;
    }
}
