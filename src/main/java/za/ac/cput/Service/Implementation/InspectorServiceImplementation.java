package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Inspector;
import za.ac.cput.Repository.InspectorRepository;
import za.ac.cput.Service.InspectorService;

import java.util.HashSet;
import java.util.Set;

public class InspectorServiceImplementation implements InspectorService{

    private static InspectorServiceImplementation inspectorServiceImplementation = null;
    private InspectorRepository inspectorRepository;

    private InspectorServiceImplementation(){
        this.inspectorRepository.getInspectorSet();
    }

    public static InspectorServiceImplementation getRepository(){
        if(inspectorServiceImplementation == null)inspectorServiceImplementation = new InspectorServiceImplementation();
        return inspectorServiceImplementation;
    }

    @Override
    public Inspector create(Inspector inspector) {return this.inspectorRepository.create(inspector);}

    @Override
    public Inspector read(String i) {
        return this.inspectorRepository.read(i);
    }

    @Override
    public Inspector update(Inspector inspector) {
        return this.inspectorRepository.update(inspector);
    }

    @Override
    public void delete(String i) {this.delete(i);}

    public Set<Inspector> getInspectorSet() {
        return this.inspectorRepository.getInspectorSet();
    }
}
