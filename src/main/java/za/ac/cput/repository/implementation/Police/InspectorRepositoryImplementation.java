package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.Police.InspectorRepository;

import java.util.*;

@Repository("InspectorRepository")
public class InspectorRepositoryImplementation implements InspectorRepository {

    private static InspectorRepositoryImplementation compRepImp = null;
    private Map<String, Inspector> inspectorSet;

    private InspectorRepositoryImplementation() {
        this.inspectorSet = new HashMap<>();
    }

    public static InspectorRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new InspectorRepositoryImplementation();
        return compRepImp;
    }

//    private Inspector findInspector(String inspectorID) {
//        return this.inspectorSet.stream()
//                .filter(inspector -> inspector.getInspectorID().trim().equals(inspectorID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Inspector create(Inspector inspector) {
        if (read(inspector.getInspectorID()) == null) {
            this.inspectorSet.put(inspector.getInspectorID(), inspector);
        }
        return inspector;
    }

    @Override
    public Inspector read(String id) {
        return this.inspectorSet.get(id);
    }

    @Override
    public Inspector update(Inspector inspector) {
        if (read(inspector.getInspectorID()) != null) {
            inspectorSet.replace(inspector.getInspectorID(), inspector);
        }
        return inspector;
    }

    @Override
    public void delete(String id) {
        Inspector inspector = read(id);
        this.inspectorSet.remove(id, inspector);

    }

    public Set<Inspector> getInspectorSet() {
        Collection<Inspector> inspector = this.inspectorSet.values();
        Set<Inspector> set = new HashSet<>();
        set.addAll(inspector);
        return set;
    }
}