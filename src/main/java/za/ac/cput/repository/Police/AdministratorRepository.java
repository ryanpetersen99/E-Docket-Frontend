package za.ac.cput.repository.Police;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Administrator;


@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    List<Administrator> findByName(String name);
}