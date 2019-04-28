package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Inspector;
import za.ac.cput.Repository.InspectorRepository;

import java.util.HashSet;
import java.util.Set;

public class InspectorRepositoryImplementation implements InspectorRepository{

    private static InspectorRepositoryImplementation inspectorRepositoryImplementation = null;
    private Set<Inspector> inspectorSet;

    private InspectorRepositoryImplementation(){
        this.inspectorSet = new HashSet<>();
    }

    public static InspectorRepositoryImplementation getRepository(){
        if(inspectorRepositoryImplementation == null)inspectorRepositoryImplementation = new InspectorRepositoryImplementation();
        return inspectorRepositoryImplementation;
    }

    @Override
    public Inspector create(Inspector inspector) {
        this.inspectorSet.add(inspector);
        return inspector;
    }

    @Override
    public Inspector read(String inspectorID) {
        return null;
    }

    @Override
    public Inspector update(Inspector inspector) {
        return inspector;
    }

    @Override
    public void delete(String inspectorID) {

    }

    public Set<Inspector> getInspectorSet() {
        return this.inspectorSet;
    }
}
