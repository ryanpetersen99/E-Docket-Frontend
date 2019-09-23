package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.repository.Police.ChiefRepository;

import java.util.*;

@Repository("ChefRepository")
public class ChiefRepositoryImplementation implements ChiefRepository {

    private static ChiefRepositoryImplementation compRepImp = null;
    private Map<String, Chief> chiefSet;

    private ChiefRepositoryImplementation() {
        this.chiefSet = new HashMap<>();
    }

    public static ChiefRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new ChiefRepositoryImplementation();
        return compRepImp;
    }

//    private Chief findChief(String chiefID) {
//        return this.chiefSet.stream()
//                .filter(chief -> chief.getChiefID().trim().equals(chiefID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Chief create(Chief chief) {
        if (read(chief.getChiefID()) == null) {
            this.chiefSet.put(chief.getChiefID(), chief);
        }
        return chief;
    }

    @Override
    public Chief read(String id) {
        return this.chiefSet.get(id);
    }

    @Override
    public Chief update(Chief chief) {
        if (read(chief.getChiefID()) != null) {
            chiefSet.replace(chief.getChiefID(), chief);
        }
        return chief;
    }

    @Override
    public void delete(String id) {
        Chief chief = read(id);
        this.chiefSet.remove(id, chief);

    }

    public Set<Chief> getChiefSet() {
        Collection<Chief> chief = this.chiefSet.values();
        Set<Chief> set = new HashSet<>();
        set.addAll(chief);
        return set;
    }
}