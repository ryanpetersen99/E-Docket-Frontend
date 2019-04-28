package za.ac.cput.Service;

import za.ac.cput.Domain.Administrator;

import java.util.Set;

public interface AdministratorService extends impService<Administrator, String> {
    Administrator create(Administrator administrator);
}
