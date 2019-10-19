package za.ac.cput.repository.Civilian;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Victim;


@Repository
public interface VictimRepository extends JpaRepository<Victim, Long> {
    List<Victim> findByName(String name);
}