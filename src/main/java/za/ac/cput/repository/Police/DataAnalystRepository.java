package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.DataAnalyst;


@Repository
public interface DataAnalystRepository extends JpaRepository<DataAnalyst, Long> {
    List<DataAnalyst> findByName(String name);
}