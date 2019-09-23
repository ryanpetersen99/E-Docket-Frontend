package za.ac.cput.service.Civilian.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.repository.Civilian.ComplainantRepository;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;
import za.ac.cput.service.Civilian.ComplainantService;

import java.util.Set;

@Service("complainantServiceImplementation")
public class ComplainantServiceImplementation implements ComplainantService {

    private static ComplainantServiceImplementation compService = null;
    private ComplainantRepository complainantRepository;

    private ComplainantServiceImplementation() {
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
    }

    public static ComplainantServiceImplementation getCompService() {
        if (compService == null) compService = new ComplainantServiceImplementation();
        return compService;
    }

    @Override
    public Complainant create(Complainant complainant) {
        return this.complainantRepository.create(complainant);
    }

    @Override
    public Complainant read(String c) {
        return this.complainantRepository.read(c);
    }

    @Override
    public Complainant update(Complainant complainant) {
        return this.complainantRepository.update(complainant);
    }

    @Override
    public void delete(String c) {
        this.complainantRepository.delete(c);
    }

    @Override
    public Set<Complainant> getAll() {
        return this.complainantRepository.getComplainantSet();
    }
}
