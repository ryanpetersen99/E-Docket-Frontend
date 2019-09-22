package za.ac.cput.service.Police;

import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.service.impService;

public interface AdministratorService extends impService<Administrator, String> {
    Administrator create(Administrator administrator);
}
