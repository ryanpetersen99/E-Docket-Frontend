package za.ac.cput.Repository.Implementation.Civillian;

import za.ac.cput.Domain.Civilian.Complainant;
import za.ac.cput.Repository.Civilian.ComplainantRepository;

import java.util.HashSet;
import java.util.Set;

public class ComplainantRepositoryImplementation implements ComplainantRepository{

    private static ComplainantRepositoryImplementation compRepImp = null;
    private Set<Complainant> complainantSet;

    private ComplainantRepositoryImplementation(){
        this.complainantSet = new HashSet<>();
    }

    public static ComplainantRepositoryImplementation getRepository(){
        if(compRepImp == null)compRepImp = new ComplainantRepositoryImplementation();
        return compRepImp;
    }

    private Complainant findComplainant(String complainantID){
        return  this.complainantSet.stream()
                .filter(complainant -> complainant.getComplainantID().trim().equals(complainantID))
                .findAny()
                .orElse(null);
    }

    @Override
    public Complainant create(Complainant complainant) {
        this.complainantSet.add(complainant);
        return complainant;
    }

    @Override
    public Complainant read(String complainantID) {
        return findComplainant(complainantID);
    }

    @Override
    public Complainant update(Complainant complainant) {
        Complainant delete = findComplainant(complainant.getComplainantID());
        if(delete != null){
            this.complainantSet.remove(delete);
            return create(complainant);
        }
        return null;
    }

    @Override
    public void delete(String complainantID) {
        Complainant complainant = findComplainant(complainantID);
       if(complainant != null) {
           this.complainantSet.remove(complainant);
       }
    }

    public Set<Complainant> getComplainantSet() {
        return this.complainantSet;
    }
}
