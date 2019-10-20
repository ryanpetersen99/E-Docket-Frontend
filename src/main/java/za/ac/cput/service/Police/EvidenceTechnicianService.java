package za.ac.cput.service.Police;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.EvidenceTechnician;

import java.util.List;


@Service
public interface EvidenceTechnicianService extends JpaRepository<EvidenceTechnician, Long> {
    List<EvidenceTechnician> findByName(String name);
}