package za.ac.cput.Repository.Implementation;



import za.ac.cput.Domain.Convict;
import za.ac.cput.Repository.ConvictRepository;

import java.util.HashSet;
import java.util.Set;

public class ConvictRepositoryImplementation implements ConvictRepository{

    private static ConvictRepositoryImplementation convictRepositoryImplementation = null;
    private Set<Convict> convictSet;

    private ConvictRepositoryImplementation(){
        this.convictSet = new HashSet<>();
    }

    public static ConvictRepositoryImplementation getRepository(){
        if(convictRepositoryImplementation == null)convictRepositoryImplementation = new ConvictRepositoryImplementation();
        return convictRepositoryImplementation;
    }

    @Override
    public Convict create(Convict convict) {
        this.convictSet.add(convict);
        return convict;
    }

    @Override
    public Convict read(String convictID) {
        return null;
    }

    @Override
    public Convict update(Convict convictID) {
        return convictID;
    }

    @Override
    public void delete(String natureOfCharge) {

    }

    public Set<Convict> getConvictSet() {
        return this.convictSet;
    }
}
