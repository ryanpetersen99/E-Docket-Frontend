package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Officer;
import za.ac.cput.Repository.Implementation.OfficerRepositoryImplementation;
import za.ac.cput.Repository.OfficerRepository;
import za.ac.cput.Service.OfficerService;

import java.util.HashSet;
import java.util.Set;

public class OfficerServiceImplementation implements OfficerService{

    private static OfficerServiceImplementation officerService = null;
    private OfficerRepository officerRepository;

    private OfficerServiceImplementation(){
        this.officerRepository = OfficerRepositoryImplementation.getRepository();
    }

    public static OfficerServiceImplementation getOfficerService(){
        if(officerService == null)officerService = new OfficerServiceImplementation();
        return officerService;
    }

    @Override
    public Officer create(Officer officer) {return this.create(officer);}

    @Override
    public Officer read(String o) { return this.read(o);}

    @Override
    public Officer update(Officer officer) {
        return this.update(officer);
    }

    @Override
    public void delete(String o) { this.delete(o);}

    public Set<Officer> getOfficerSet() {
        return this.officerRepository.getOfficerSet();
    }
}
