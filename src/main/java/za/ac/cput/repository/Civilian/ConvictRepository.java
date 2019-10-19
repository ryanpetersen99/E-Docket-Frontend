package za.ac.cput.repository.Civilian;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Convict;


@Repository
public interface ConvictRepository extends JpaRepository<Convict, Long> {
    List<Convict> findByName(String name);
}