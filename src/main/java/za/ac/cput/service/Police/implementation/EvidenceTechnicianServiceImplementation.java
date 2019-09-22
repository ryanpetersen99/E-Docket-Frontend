package za.ac.cput.service.Police.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.repository.Police.Evidence_TechnicianRepository;
import za.ac.cput.repository.implementation.Police.EvidenceTechnicianRepositoryImplementation;
import za.ac.cput.service.Police.Evidence_TechnicianService;

import java.util.Set;

@Service("EvidenceTechnicianServiceImplementation")
public class EvidenceTechnicianServiceImplementation implements Evidence_TechnicianService {

    private static EvidenceTechnicianServiceImplementation etService = null;
    private Evidence_TechnicianRepository dataAnalystRepository;

    private EvidenceTechnicianServiceImplementation() {
        this.dataAnalystRepository = EvidenceTechnicianRepositoryImplementation.getRepository();
    }

    public static EvidenceTechnicianServiceImplementation getETService() {
        if (etService == null) etService = new EvidenceTechnicianServiceImplementation();
        return etService;
    }

    @Override
    public EvidenceTechnician create(EvidenceTechnician dataAnalyst) {
        return this.dataAnalystRepository.create(dataAnalyst);
    }

    @Override
    public EvidenceTechnician read(String d) {
        return this.dataAnalystRepository.read(d);
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician dataAnalyst) {
        return this.dataAnalystRepository.update(dataAnalyst);
    }

    @Override
    public void delete(String d) {
        this.dataAnalystRepository.delete(d);
    }

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        return this.dataAnalystRepository.getEvidenceTechnicianSet();
    }
}
