package za.ac.cput.Repository.Police;

import za.ac.cput.Domain.Police.Administrator;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface AdministratorRepository extends impRepository<Administrator, String> {
    Set<Administrator> getAdministratorSet();
}
