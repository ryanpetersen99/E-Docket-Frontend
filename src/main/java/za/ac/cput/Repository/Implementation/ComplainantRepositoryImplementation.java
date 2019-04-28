package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Complainant;
import za.ac.cput.Repository.ComplainantRepository;

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

    @Override
    public Complainant create(Complainant complainant) {
        this.complainantSet.add(complainant);
        return complainant;
    }

    @Override
    public Complainant read(String complainantID) {
        return null;
    }

    @Override
    public Complainant update(Complainant complainant) {
        return complainant;
    }

    @Override
    public void delete(String complainantID) {

    }

    public Set<Complainant> getComplainantSet() {
        return this.complainantSet;
    }
}
