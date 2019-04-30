package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Repository.Implementation.Police.OfficerRepositoryImplementation;
import za.ac.cput.Repository.Police.OfficerRepository;
import za.ac.cput.Service.Police.OfficerService;

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
