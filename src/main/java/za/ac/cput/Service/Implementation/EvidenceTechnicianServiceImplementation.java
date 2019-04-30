package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Repository.Police.Evidence_TechnicianRepository;
import za.ac.cput.Service.Police.Evidence_TechnicianService;

import java.util.Set;

public class EvidenceTechnicianServiceImplementation implements Evidence_TechnicianService{

    private static EvidenceTechnicianServiceImplementation evidenceTechnicianServiceImplementation = null;
    private Evidence_TechnicianRepository evidence_technicianRepository;

    private EvidenceTechnicianServiceImplementation(){
        this.evidence_technicianRepository.getEvidenceTechnicianSet();
    }

    public static EvidenceTechnicianServiceImplementation getRepository(){
        if(evidenceTechnicianServiceImplementation == null)evidenceTechnicianServiceImplementation = new EvidenceTechnicianServiceImplementation();
        return evidenceTechnicianServiceImplementation;
    }

    @Override
    public EvidenceTechnician create(EvidenceTechnician evidenceTechnician) { return this.evidence_technicianRepository.create(evidenceTechnician);}

    @Override
    public EvidenceTechnician read(String e) {
        return this.read(e);
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician evidenceTechnician) {
        return this.update(evidenceTechnician);
    }

    @Override
    public void delete(String e) { this.delete(e);}

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        return this.evidence_technicianRepository.getEvidenceTechnicianSet();
    }
}
