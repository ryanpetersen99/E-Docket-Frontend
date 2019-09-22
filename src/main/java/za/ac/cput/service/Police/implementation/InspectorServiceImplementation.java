package za.ac.cput.service.Police.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.Police.InspectorRepository;
import za.ac.cput.repository.Police.InspectorRepository;
import za.ac.cput.repository.implementation.Police.InspectorRepositoryImplementation;
import za.ac.cput.service.Police.InspectorService;
import za.ac.cput.service.Police.InspectorService;

import java.util.Set;

@Service("InspectorServiceImplementation")
public class InspectorServiceImplementation implements InspectorService {

    private static InspectorServiceImplementation inspectorService = null;
    private InspectorRepository dataAnalystRepository;

    private InspectorServiceImplementation() {
        this.dataAnalystRepository = InspectorRepositoryImplementation.getRepository();
    }

    public static InspectorServiceImplementation getInspectorService() {
        if (inspectorService == null) inspectorService = new InspectorServiceImplementation();
        return inspectorService;
    }

    @Override
    public Inspector create(Inspector dataAnalyst) {
        return this.dataAnalystRepository.create(dataAnalyst);
    }

    @Override
    public Inspector read(String d) {
        return this.dataAnalystRepository.read(d);
    }

    @Override
    public Inspector update(Inspector dataAnalyst) {
        return this.dataAnalystRepository.update(dataAnalyst);
    }

    @Override
    public void delete(String d) {
        this.dataAnalystRepository.delete(d);
    }

    public Set<Inspector> getInspectorSet() {
        return this.dataAnalystRepository.getInspectorSet();
    }
}
