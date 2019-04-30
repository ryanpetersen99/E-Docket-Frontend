package za.ac.cput.Repository.Implementation.Civillian;



import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Repository.Civillian.ConvictRepository;

import java.util.HashSet;
import java.util.Set;

public class ConvictRepositoryImplementation implements ConvictRepository{

    private static ConvictRepositoryImplementation convictRepositoryImplementation = null;
    private Set<Convict> convictSet;
    private Convict convict;

    private Convict findConvict(String convictID){
        return  this.convictSet.stream()
                .filter(convict -> convict.getConvictID().trim().equals(convictID))
                .findAny()
                .orElse(null);
    }

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
        return findConvict(convictID);
    }

    @Override
    public Convict update(Convict convict) {
        Convict delete = findConvict(convict.getConvictID());
        if(delete != null){
            this.convictSet.remove(delete);
            return create(convict);
        }
        return null;
    }

    @Override
    public void delete(String convictID) {
        Convict convict = findConvict(convictID);
        if(convict != null) {
            this.convictSet.remove(convict);
        }
    }

    public Set<Convict> getConvictSet() {
        return this.convictSet;
    }
}
