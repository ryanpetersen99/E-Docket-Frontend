package za.ac.cput.service.Police.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.Police.InspectorRepository;
import za.ac.cput.repository.implementation.Police.InspectorRepositoryImplementation;
import za.ac.cput.service.Police.InspectorService;

import java.util.Set;

@Service("InspectorServiceImplementation")
public class InspectorServiceImplementation implements InspectorService {

    private static InspectorServiceImplementation inspectorService = null;
    private InspectorRepository inspectorRepository;

    private InspectorServiceImplementation() {
        this.inspectorRepository = InspectorRepositoryImplementation.getRepository();
    }

    public static InspectorServiceImplementation getInspectorService() {
        if (inspectorService == null) inspectorService = new InspectorServiceImplementation();
        return inspectorService;
    }

    @Override
    public Inspector create(Inspector inspector) {
        return this.inspectorRepository.create(inspector);
    }

    @Override
    public Inspector read(String d) {
        return this.inspectorRepository.read(d);
    }

    @Override
    public Inspector update(Inspector inspector) {
        return this.inspectorRepository.update(inspector);
    }

    @Override
    public void delete(String d) {
        this.inspectorRepository.delete(d);
    }

    public Set<Inspector> getInspectorSet() {
        return this.inspectorRepository.getInspectorSet();
    }
}
