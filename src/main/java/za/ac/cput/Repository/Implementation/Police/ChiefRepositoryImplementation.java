package za.ac.cput.Repository.Implementation.Police;

import za.ac.cput.Domain.Police.Chief;
import za.ac.cput.Repository.Police.ChiefRepository;

import java.util.HashSet;
import java.util.Set;

public class ChiefRepositoryImplementation implements ChiefRepository{

    private static ChiefRepositoryImplementation chiefImp = null;
    private Set<Chief> chiefSet;

    private ChiefRepositoryImplementation(){
        this.chiefSet = new HashSet<>();
    }


    private Chief findChief(String chiefID){
        return  this.chiefSet.stream()
                .filter(chief -> chief.getChiefID().trim().equals(chiefID))
                .findAny()
                .orElse(null);
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
        return findChief(chiefID);
    }

    @Override
    public Chief update(Chief chief) {
        Chief delete = findChief(chief.getChiefID());
        if(delete != null){
            this.chiefSet.remove(delete);
            return create(chief);
        }
        return null;
    }

    @Override
    public void delete(String chiefID) {
        Chief chief = findChief(chiefID);
        if(chief != null) {
            this.chiefSet.remove(chief);
        }
    }

    public Set<Chief> getChiefSet() {
        return this.chiefSet;
    }
}
