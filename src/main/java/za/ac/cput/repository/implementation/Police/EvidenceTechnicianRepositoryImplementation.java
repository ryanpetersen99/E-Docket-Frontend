package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.EvidenceTechnician;
import za.ac.cput.repository.Police.EvidenceTechnicianRepository;

import java.util.*;

@Repository("EvidenceTechnicianRepository")
public class EvidenceTechnicianRepositoryImplementation implements EvidenceTechnicianRepository {

    private static EvidenceTechnicianRepositoryImplementation compRepImp = null;
    private Map<String, EvidenceTechnician> etSet;

    private EvidenceTechnicianRepositoryImplementation() {
        this.etSet = new HashMap<>();
    }

    public static EvidenceTechnicianRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new EvidenceTechnicianRepositoryImplementation();
        return compRepImp;
    }

//    private EvidenceTechnician findEvidenceTechnician(String etID) {
//        return this.etSet.stream()
//                .filter(et -> et.getEvidenceTechnicianID().trim().equals(etID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public EvidenceTechnician create(EvidenceTechnician et) {
        if (read(et.getEvidenceTechID()) == null) {
            this.etSet.put(et.getEvidenceTechID(), et);
        }
        return et;
    }

    @Override
    public EvidenceTechnician read(String id) {
        return this.etSet.get(id);
    }

    @Override
    public EvidenceTechnician update(EvidenceTechnician et) {
        if (read(et.getEvidenceTechID()) != null) {
            etSet.replace(et.getEvidenceTechID(), et);
        }
        return et;
    }

    @Override
    public void delete(String id) {
        EvidenceTechnician et = read(id);
        this.etSet.remove(id, et);

    }

    public Set<EvidenceTechnician> getEvidenceTechnicianSet() {
        Collection<EvidenceTechnician> et = this.etSet.values();
        Set<EvidenceTechnician> set = new HashSet<>();
        set.addAll(et);
        return set;
    }
}