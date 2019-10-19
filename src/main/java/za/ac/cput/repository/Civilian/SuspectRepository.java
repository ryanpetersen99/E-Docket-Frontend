package za.ac.cput.repository.Civilian;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Suspect;


@Repository
public interface SuspectRepository extends JpaRepository<Suspect, Long> {
    List<Suspect> findByName(String name);
}