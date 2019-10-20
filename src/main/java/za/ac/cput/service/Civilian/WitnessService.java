package za.ac.cput.service.Civilian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Witness;

import java.util.List;


@Service
public interface WitnessService extends JpaRepository<Witness, Long> {
    List<Witness> findByName(String name);
}