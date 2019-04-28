package za.ac.cput.Repository;

import za.ac.cput.Domain.Administrator;

import java.util.Set;

public interface AdministratorRepository extends impRepository<Administrator, String> {
    Set<Administrator> getAdministratorSet();
}
