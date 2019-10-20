package za.ac.cput.service.Police;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Inspector;

import java.util.List;


@Service
public interface InspectorService extends JpaRepository<Inspector, Long> {
    List<Inspector> findByName(String name);
}