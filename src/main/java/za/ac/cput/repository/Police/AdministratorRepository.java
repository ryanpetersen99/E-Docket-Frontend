package za.ac.cput.repository.Police;

import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface AdministratorRepository extends impRepository<Administrator, String> {
    Set<Administrator> getAdministratorSet();
}
