package za.ac.cput.service.Police.implementation;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.repository.Police.AdministratorRepository;
import za.ac.cput.repository.implementation.Police.AdministratorRepositoryImplementation;
import za.ac.cput.service.Police.AdministratorService;

import java.util.Set;

@Service("AdministratorServiceImplementation")
public class AdministratorServiceImplementation implements AdministratorService {

    private static AdministratorServiceImplementation adminService = null;
    private AdministratorRepository administratorRepository;

    private AdministratorServiceImplementation() {
        this.administratorRepository = AdministratorRepositoryImplementation.getRepository();
    }

    public static AdministratorService getAdminService() {
        if (adminService == null) adminService = new AdministratorServiceImplementation();
        return adminService;
    }

    @Override
    public Administrator create(Administrator administrator) {
        return this.administratorRepository.create(administrator);
    }

    @Override
    public Administrator read(String a) {
        return this.administratorRepository.read(a);
    }

    @Override
    public Administrator update(Administrator administrator) {
        return this.administratorRepository.update(administrator);
    }

    @Override
    public void delete(String a) {
        this.administratorRepository.delete(a);
    }

    public Set<Administrator> getAdministratorSet() {
        return this.administratorRepository.getAdministratorSet();
    }
}
