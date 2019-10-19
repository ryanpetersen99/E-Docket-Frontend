package za.ac.cput.repository.Civilian;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Complainant;


@Repository
public interface ComplainantRepository extends JpaRepository<Complainant, Long> {
    List<Complainant> findByName(String name);
}