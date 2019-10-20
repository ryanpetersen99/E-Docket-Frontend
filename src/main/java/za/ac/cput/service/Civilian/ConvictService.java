package za.ac.cput.service.Civilian;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Convict;

import java.util.List;


@Service
public interface ConvictService extends JpaRepository<Convict, Long> {
    List<Convict> findByName(String name);
}