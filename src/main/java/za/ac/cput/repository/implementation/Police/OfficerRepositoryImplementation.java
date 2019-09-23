package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.repository.Police.OfficerRepository;

import java.util.*;

@Repository("OfficerRepository")
public class OfficerRepositoryImplementation implements OfficerRepository {

    private static OfficerRepositoryImplementation compRepImp = null;
    private Map<String, Officer> officerSet;

    private OfficerRepositoryImplementation() {
        this.officerSet = new HashMap<>();
    }

    public static OfficerRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new OfficerRepositoryImplementation();
        return compRepImp;
    }

//    private Officer findOfficer(String officerID) {
//        return this.officerSet.stream()
//                .filter(officer -> officer.getOfficerID().trim().equals(officerID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Officer create(Officer officer) {
        if (read(officer.getOfficerID()) == null) {
            this.officerSet.put(officer.getOfficerID(), officer);
        }
        return officer;
    }

    @Override
    public Officer read(String id) {
        return this.officerSet.get(id);
    }

    @Override
    public Officer update(Officer officer) {
        if (read(officer.getOfficerID()) != null) {
            officerSet.replace(officer.getOfficerID(), officer);
        }
        return officer;
    }

    @Override
    public void delete(String id) {
        Officer officer = read(id);
        this.officerSet.remove(id, officer);

    }

    public Set<Officer> getOfficerSet() {
        Collection<Officer> officer = this.officerSet.values();
        Set<Officer> set = new HashSet<>();
        set.addAll(officer);
        return set;
    }
}