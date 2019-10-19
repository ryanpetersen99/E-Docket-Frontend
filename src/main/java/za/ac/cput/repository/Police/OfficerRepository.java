package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Officer;


@Repository
public interface OfficerRepository extends JpaRepository<Officer, Long> {
    List<Officer> findByName(String name);
}