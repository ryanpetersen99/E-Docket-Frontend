package za.ac.cput.service.Civilian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Victim;

import java.util.List;


@Service
public interface VictimService extends JpaRepository<Victim, Long> {
    List<Victim> findByName(String name);
}