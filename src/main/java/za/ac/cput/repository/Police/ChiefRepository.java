package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Chief;


@Repository
public interface ChiefRepository extends JpaRepository<Chief, Long> {
    List<Chief> findByName(String name);
}