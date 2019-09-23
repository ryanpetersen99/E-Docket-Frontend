package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.repository.Civilian.ComplainantRepository;

import java.util.*;

@Repository("ComplainantRepository")
public class ComplainantRepositoryImplementation implements ComplainantRepository {

    private static ComplainantRepositoryImplementation compRepImp = null;
    private Map<String, Complainant> complainantSet;

    private ComplainantRepositoryImplementation() {
        this.complainantSet = new HashMap<>();
    }

    public static ComplainantRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new ComplainantRepositoryImplementation();
        return compRepImp;
    }

//    private Complainant findComplainant(String complainantID) {
//        return this.complainantSet.stream()
//                .filter(complainant -> complainant.getComplainantID().trim().equals(complainantID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Complainant create(Complainant complainant) {
        if (read(complainant.getComplainantID()) == null) {
            this.complainantSet.put(complainant.getComplainantID(), complainant);
        }
        return complainant;
    }

    @Override
    public Complainant read(String id) {
        return this.complainantSet.get(id);
    }

    @Override
    public Complainant update(Complainant complainant) {
        if (read(complainant.getComplainantID()) != null) {
            complainantSet.replace(complainant.getComplainantID(), complainant);
        }
        return complainant;
    }

    @Override
    public void delete(String id) {
        Complainant complainant = read(id);
        this.complainantSet.remove(id, complainant);

    }

    public Set<Complainant> getComplainantSet() {
        Collection<Complainant> comp = this.complainantSet.values();
        Set<Complainant> set = new HashSet<>();
        set.addAll(comp);
        return set;
    }
}
