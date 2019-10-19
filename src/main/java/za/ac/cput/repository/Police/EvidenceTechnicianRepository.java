package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.EvidenceTechnician;


@Repository
public interface EvidenceTechnicianRepository extends JpaRepository<EvidenceTechnician, Long> {
    List<EvidenceTechnician> findByName(String name);
}