package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Chief;
import za.ac.cput.Repository.ChiefRepository;

import java.util.HashSet;
import java.util.Set;

public class ChiefRepositoryImplementation implements ChiefRepository{

    private static ChiefRepositoryImplementation chiefImp = null;
    private Set<Chief> chiefSet;

    private ChiefRepositoryImplementation(){
        this.chiefSet = new HashSet<>();
    }

    public static ChiefRepositoryImplementation getRepository(){
        if(chiefImp == null)chiefImp = new ChiefRepositoryImplementation();
        return chiefImp;
    }

    @Override
    public Chief create(Chief chief) {
        this.chiefSet.add(chief);
        return chief;
    }

    @Override
    public Chief read(String chiefID) {
        return null;
    }

    @Override
    public Chief update(Chief chief) {
        return chief;
    }

    @Override
    public void delete(String chiefID) {

    }

    public Set<Chief> getChiefSet() {
        return this.chiefSet;
    }
}
