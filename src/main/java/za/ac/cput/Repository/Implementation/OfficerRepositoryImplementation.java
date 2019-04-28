package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Officer;
import za.ac.cput.Repository.OfficerRepository;

import java.util.HashSet;
import java.util.Set;

public class OfficerRepositoryImplementation implements OfficerRepository{

    private static OfficerRepositoryImplementation officerRepImp = null;
    private Set<Officer> officerSet;

    private OfficerRepositoryImplementation(){
        this.officerSet = new HashSet<>();
    }

    public static OfficerRepositoryImplementation getRepository(){
        if(officerRepImp == null)officerRepImp = new OfficerRepositoryImplementation();
        return officerRepImp;
    }

    @Override
    public Officer create(Officer officer) {
        this.officerSet.add(officer);
        return officer;
    }

    @Override
    public Officer read(String officerID) {
        return null;
    }

    @Override
    public Officer update(Officer officer) {
        return officer;
    }

    @Override
    public void delete(String officerID) {

    }

    public Set<Officer> getOfficerSet() {
        return this.officerSet;
    }
}
