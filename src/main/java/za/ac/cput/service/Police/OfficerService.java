package za.ac.cput.service.Police;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Officer;

import java.util.List;


@Service
public interface OfficerService extends JpaRepository<Officer, Long> {
    List<Officer> findByName(String name);
}