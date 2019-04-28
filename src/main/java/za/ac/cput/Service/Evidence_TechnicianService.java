package za.ac.cput.Service;


import za.ac.cput.Domain.EvidenceTechnician;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface Evidence_TechnicianService extends impService<EvidenceTechnician, String> {
    EvidenceTechnician create(EvidenceTechnician evidenceTechnician);
}
