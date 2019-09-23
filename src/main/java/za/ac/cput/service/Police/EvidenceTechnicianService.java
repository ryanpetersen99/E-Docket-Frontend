package za.ac.cput.service.Police;


import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.service.impService;

public interface EvidenceTechnicianService extends impService<EvidenceTechnician, String> {
    EvidenceTechnician create(EvidenceTechnician evidenceTechnician);
}
