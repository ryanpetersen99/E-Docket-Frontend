package za.ac.cput.service.Police.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.repository.Police.EvidenceTechnicianRepository;
import za.ac.cput.repository.implementation.Police.EvidenceTechnicianRepositoryImplementation;
import za.ac.cput.service.Police.EvidenceTechnicianService;

import java.util.Set;

@Service("EvidenceTechnicianServiceImplementation")
public class EvidenceTechnicianServiceImplementation implements EvidenceTechnicianService {

    private static EvidenceTechnicianServiceImplementation etService = null;
    private EvidenceTechnicianRepository etRepository;

    private EvidenceTechnicianServiceImplementation() {
        this.etRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
    }

    public static EvidenceTechnicianServiceImplementation getETService() {
        if (etService == null) etService = new EvidenceTechnicianServiceImplementation();
        return etService;
    }

    @Override
    public EvidenceTechnician create(EvidenceTechnician et) {
        return this.etRepository.create(et);
    }

    @Override
    public EvidenceTechnician read(String d) {
        return this.etRepository.read(d);
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician et) {
        return this.etRepository.update(et);
    }

    @Override
    public void delete(String d) {
        this.etRepository.delete(d);
    }

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        return this.etRepository.getEvidenceTechnicianSet();
    }
}
