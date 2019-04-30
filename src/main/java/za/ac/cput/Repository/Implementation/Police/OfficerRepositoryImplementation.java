package za.ac.cput.Repository.Implementation.Police;

import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Repository.Police.OfficerRepository;

import java.util.HashSet;
import java.util.Set;

public class OfficerRepositoryImplementation implements OfficerRepository{

    private static OfficerRepositoryImplementation officerRepImp = null;
    private Set<Officer> officerSet;

    private OfficerRepositoryImplementation(){
        this.officerSet = new HashSet<>();
    }

    private Officer findOfficer(String officerID){
        return  this.officerSet.stream()
                .filter(officer -> officer.getOfficerID().trim().equals(officerID))
                .findAny()
                .orElse(null);
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
        return findOfficer(officerID);
    }

    @Override
    public Officer update(Officer officer) {
        Officer delete = findOfficer(officer.getOfficerID());
        if(delete != null){
            this.officerSet.remove(delete);
            return create(officer);
        }
        return null;
    }

    @Override
    public void delete(String officerID) {
        Officer officer = findOfficer(officerID);
        if (officer != null) {
            this.officerSet.remove(officer);
        }
    }

    public Set<Officer> getOfficerSet() {
        return this.officerSet;
    }
}
