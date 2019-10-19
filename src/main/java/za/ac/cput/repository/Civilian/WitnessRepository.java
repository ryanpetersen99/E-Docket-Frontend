package za.ac.cput.repository.Civilian;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Witness;


@Repository
public interface WitnessRepository extends JpaRepository<Witness, Long> {
    List<Witness> findByName(String name);
}