package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Inspector;


@Repository
public interface InspectorRepository extends JpaRepository<Inspector, Long> {
    List<Inspector> findByName(String name);
}