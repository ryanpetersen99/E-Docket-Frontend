package za.ac.cput.service.Police;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Administrator;

import java.util.List;


@Service
public interface AdministratorService extends JpaRepository<Administrator, Long> {
    List<Administrator> findByName(String name);
}