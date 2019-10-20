package za.ac.cput.service.Civilian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Suspect;

import java.util.List;


@Service
public interface SuspectService extends JpaRepository<Suspect, Long> {
    List<Suspect> findByName(String name);
}