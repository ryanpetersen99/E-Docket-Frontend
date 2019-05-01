package za.ac.cput.Repository.Implementation.Police;

import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Repository.Police.Evidence_TechnicianRepository;

import java.util.HashSet;
import java.util.Set;

public class EvidenceTechnicianRepositoryImplementation implements Evidence_TechnicianRepository{

    private static EvidenceTechnicianRepositoryImplementation evidenceTechnicianRepositoryImplementation = null;
    private Set<EvidenceTechnician> evidence_technicianSet;

    private EvidenceTechnicianRepositoryImplementation(){
        this.evidence_technicianSet = new HashSet<>();
    }


    private EvidenceTechnician findEvidenceTech(String evidenceTechID){
        return  this.evidence_technicianSet.stream()
                .filter(evidenceTechnician -> evidenceTechnician.getEvidenceTechID().trim().equals(evidenceTechID))
                .findAny()
                .orElse(null);
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
        return findEvidenceTech(evidTechID);
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician evidenceTechnician) {
        EvidenceTechnician delete = findEvidenceTech(evidenceTechnician.getEvidenceTechID());
        if(delete != null){
            this.evidence_technicianSet.remove(delete);
            return create(evidenceTechnician);
        }
        return null;
    }

    @Override
    public void delete(String evidTechID) {
        EvidenceTechnician evidenceTechnician = findEvidenceTech(evidTechID);
        if(evidenceTechnician != null) {
            this.evidence_technicianSet.remove(evidenceTechnician);
        }
    }

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        return this.evidence_technicianSet;
    }
}
