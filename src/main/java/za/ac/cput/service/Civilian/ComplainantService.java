package za.ac.cput.service.Civilian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Complainant;

import java.util.List;


@Service
public interface ComplainantService extends JpaRepository<Complainant, Long> {
    List<Complainant> findByName(String name);
}