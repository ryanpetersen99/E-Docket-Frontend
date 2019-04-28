package za.ac.cput.Service.Implementation;


import za.ac.cput.Domain.Administrator;
import za.ac.cput.Repository.AdministratorRepository;
import za.ac.cput.Repository.Implementation.AdministratorRepositoryImplementation;
import za.ac.cput.Service.AdministratorService;

import java.util.HashSet;
import java.util.Set;

public class AdministratorServiceImplementation implements AdministratorService{

    private static AdministratorServiceImplementation adminService= null;
    private AdministratorRepository administratorRepository;

    private AdministratorServiceImplementation(){
        this.administratorRepository = AdministratorRepositoryImplementation.getRepository();
    }

    public static AdministratorService getAdminService(){
        if(adminService == null)adminService = new AdministratorServiceImplementation();
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
    public void delete(String a) { this.administratorRepository.delete(a); }

    public Set<Administrator> getAdministratorSet() {
        return this.administratorRepository.getAdministratorSet();
    }
}
