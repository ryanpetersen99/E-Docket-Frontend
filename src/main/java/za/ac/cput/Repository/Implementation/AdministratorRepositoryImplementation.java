package za.ac.cput.Repository.Implementation;


import za.ac.cput.Domain.Administrator;
import za.ac.cput.Repository.AdministratorRepository;

import java.util.HashSet;
import java.util.Set;

public class AdministratorRepositoryImplementation implements AdministratorRepository{

    private static AdministratorRepositoryImplementation adminRepImp = null;
    private Set<Administrator> administratorSet;

    private AdministratorRepositoryImplementation(){
        this.administratorSet = new HashSet<>();
    }

    public static AdministratorRepositoryImplementation getRepository(){
        if(adminRepImp == null)adminRepImp = new AdministratorRepositoryImplementation();
        return adminRepImp;
    }

    @Override
    public Administrator create(Administrator administrator) {
        this.administratorSet.add(administrator);
        return administrator;
    }

    @Override
    public Administrator read(String adminID) {
        return null;
    }

    @Override
    public Administrator update(Administrator administrator) {
        return administrator;
    }

    @Override
    public void delete(String adminID) {

    }

    public Set<Administrator> getAdministratorSet() {
        return this.administratorSet;
    }
}
