package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.Police.InspectorRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("InspectorRepository")
public class InspectorRepositoryImplementation implements InspectorRepository {

    private static InspectorRepositoryImplementation inspectorRepositoryImplementation = null;
    private Set<Inspector> inspectorSet;

    private InspectorRepositoryImplementation() {
        this.inspectorSet = new HashSet<>();
    }

    public static InspectorRepositoryImplementation getRepository() {
        if (inspectorRepositoryImplementation == null)
            inspectorRepositoryImplementation = new InspectorRepositoryImplementation();
        return inspectorRepositoryImplementation;
    }

    private Inspector findInspector(String inspectorID) {
        return this.inspectorSet.stream()
                .filter(inspector -> inspector.getInspectorID().trim().equals(inspectorID))
                .findAny()
                .orElse(null);
    }


    @Override
    public Inspector create(Inspector inspector) {
        this.inspectorSet.add(inspector);
        return inspector;
    }

    @Override
    public Inspector read(String inspectorID) {
        return findInspector(inspectorID);
    }

    @Override
    public Inspector update(Inspector inspector) {
        Inspector delete = findInspector(inspector.getInspectorID());
        if (delete != null) {
            this.inspectorSet.remove(delete);
            return create(inspector);
        }
        return null;
    }

    @Override
    public void delete(String inspectorID) {
        Inspector inspector = findInspector(inspectorID);
        if (inspector != null) {
            this.inspectorSet.remove(inspector);
        }
    }

    public Set<Inspector> getInspectorSet() {
        return this.inspectorSet;
    }
}
