package za.ac.cput.repository.Police;


import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface Evidence_TechnicianRepository extends impRepository<EvidenceTechnician, String> {
    Set<EvidenceTechnician> getEvidenceTechnicianSet();
}
