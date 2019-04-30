package za.ac.cput.Service.Police;


import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Service.impService;

public interface Evidence_TechnicianService extends impService<EvidenceTechnician, String> {
    EvidenceTechnician create(EvidenceTechnician evidenceTechnician);
}
