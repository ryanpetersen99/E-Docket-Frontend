package za.ac.cput.Service.Police;

import za.ac.cput.Domain.Police.Administrator;
import za.ac.cput.Service.impService;

public interface AdministratorService extends impService<Administrator, String> {
    Administrator create(Administrator administrator);
}
