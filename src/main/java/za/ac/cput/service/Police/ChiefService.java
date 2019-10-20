package za.ac.cput.service.Police;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Chief;

import java.util.List;


@Service
public interface ChiefService extends JpaRepository<Chief, Long> {
    List<Chief> findByName(String name);
}