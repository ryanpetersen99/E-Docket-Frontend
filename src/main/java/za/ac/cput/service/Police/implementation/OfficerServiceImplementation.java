package za.ac.cput.service.Police.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.repository.Police.OfficerRepository;
import za.ac.cput.repository.implementation.Police.OfficerRepositoryImplementation;
import za.ac.cput.service.Police.OfficerService;

import java.util.Set;

@Service("OfficerServiceImplementation")
public class OfficerServiceImplementation implements OfficerService {

    private static OfficerServiceImplementation officerService = null;
    private OfficerRepository officerRepository;

    private OfficerServiceImplementation() {
        this.officerRepository = OfficerRepositoryImplementation.getRepository();
    }

    public static OfficerServiceImplementation getOfficerService() {
        if (officerService == null) officerService = new OfficerServiceImplementation();
        return officerService;
    }

    @Override
    public Officer create(Officer officer) {
        return this.officerRepository.create(officer);
    }

    @Override
    public Officer read(String o) {
        return this.officerRepository.read(o);
    }

    @Override
    public Officer update(Officer officer) {
        return this.officerRepository.update(officer);
    }

    @Override
    public void delete(String o) {
        this.officerRepository.delete(o);
    }

    @Override
    public Set<Officer> getAll() {
        return this.officerRepository.getOfficerSet();
    }
}
