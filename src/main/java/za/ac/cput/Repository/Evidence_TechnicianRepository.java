package za.ac.cput.Repository;


import za.ac.cput.Domain.EvidenceTechnician;

import java.util.Set;

public interface Evidence_TechnicianRepository extends impRepository<EvidenceTechnician, String> {
    Set<EvidenceTechnician> getEvidenceTechnicianSet();
}
