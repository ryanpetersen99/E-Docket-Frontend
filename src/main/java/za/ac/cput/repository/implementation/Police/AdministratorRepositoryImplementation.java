package za.ac.cput.repository.implementation.Police;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.repository.Police.AdministratorRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("AdministratorRepository")
public class AdministratorRepositoryImplementation implements AdministratorRepository {

    private static AdministratorRepositoryImplementation adminRepImp = null;
    private Set<Administrator> administratorSet;

    private AdministratorRepositoryImplementation() {
        this.administratorSet = new HashSet<>();
    }


    private Administrator findAdministrator(String administratorID) {
        return this.administratorSet.stream()
                .filter(administrator -> administrator.getAdminID().trim().equals(administratorID))
                .findAny()
                .orElse(null);
    }

    public static AdministratorRepositoryImplementation getRepository() {
        if (adminRepImp == null) adminRepImp = new AdministratorRepositoryImplementation();
        return adminRepImp;
    }

    @Override
    public Administrator create(Administrator administrator) {
        this.administratorSet.add(administrator);
        return administrator;
    }

    @Override
    public Administrator read(String adminID) {
        return findAdministrator(adminID);
    }

    @Override
    public Administrator update(Administrator administrator) {
        Administrator delete = findAdministrator(administrator.getAdminID());
        if (delete != null) {
            this.administratorSet.remove(delete);
            return create(administrator);
        }
        return null;
    }

    @Override
    public void delete(String adminID) {
        Administrator administrator = findAdministrator(adminID);
        if (administrator != null) {
            this.administratorSet.remove(administrator);
        }

    }

    public Set<Administrator> getAdministratorSet() {
        return this.administratorSet;
    }
}
