package za.ac.cput.repository.implementation.Police;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.repository.Police.AdministratorRepository;

import java.util.*;

@Repository("AdministratorRepository")
public class AdministratorRepositoryImplementation implements AdministratorRepository {

    private static AdministratorRepositoryImplementation compRepImp = null;
    private Map<String, Administrator> adminSet;

    private AdministratorRepositoryImplementation() {
        this.adminSet = new HashMap<>();
    }

    public static AdministratorRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new AdministratorRepositoryImplementation();
        return compRepImp;
    }

//    private Administrator findAdministrator(String adminID) {
//        return this.adminSet.stream()
//                .filter(admin -> admin.getAdministratorID().trim().equals(adminID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Administrator create(Administrator admin) {
        if (read(admin.getAdminID()) == null) {
            this.adminSet.put(admin.getAdminID(), admin);
        }
        return admin;
    }

    @Override
    public Administrator read(String id) {
        return this.adminSet.get(id);
    }

    @Override
    public Administrator update(Administrator admin) {
        if (read(admin.getAdminID()) != null) {
            adminSet.replace(admin.getAdminID(), admin);
        }
        return admin;
    }

    @Override
    public void delete(String id) {
        Administrator admin = read(id);
        this.adminSet.remove(id, admin);

    }

    public Set<Administrator> getAdministratorSet() {
        Collection<Administrator> admin = this.adminSet.values();
        Set<Administrator> set = new HashSet<>();
        set.addAll(admin);
        return set;
    }
}