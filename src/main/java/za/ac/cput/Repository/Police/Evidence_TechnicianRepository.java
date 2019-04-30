package za.ac.cput.Repository.Police;


import za.ac.cput.Domain.Police.EvidenceTechnician;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface Evidence_TechnicianRepository extends impRepository<EvidenceTechnician, String> {
    Set<EvidenceTechnician> getEvidenceTechnicianSet();
}
