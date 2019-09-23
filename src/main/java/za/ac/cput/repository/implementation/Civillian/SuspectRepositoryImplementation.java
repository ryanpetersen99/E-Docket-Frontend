package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.repository.Civilian.SuspectRepository;

import java.util.*;

@Repository("SuspectRepository")
public class SuspectRepositoryImplementation implements SuspectRepository {

    private static SuspectRepositoryImplementation compRepImp = null;
    private Map<String, Suspect> suspectSet;

    private SuspectRepositoryImplementation() {
        this.suspectSet = new HashMap<>();
    }

    public static SuspectRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new SuspectRepositoryImplementation();
        return compRepImp;
    }

//    private Suspect findSuspect(String suspectID) {
//        return this.suspectSet.stream()
//                .filter(suspect -> suspect.getSuspectID().trim().equals(suspectID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Suspect create(Suspect suspect) {
        if (read(suspect.getSuspectID()) == null) {
            this.suspectSet.put(suspect.getSuspectID(), suspect);
        }
        return suspect;
    }

    @Override
    public Suspect read(String id) {
        return this.suspectSet.get(id);
    }

    @Override
    public Suspect update(Suspect suspect) {
        if (read(suspect.getSuspectID()) != null) {
            suspectSet.replace(suspect.getSuspectID(), suspect);
        }
        return suspect;
    }

    @Override
    public void delete(String id) {
        Suspect suspect = read(id);
        this.suspectSet.remove(id, suspect);

    }

    public Set<Suspect> getSuspectSet() {
        Collection<Suspect> suspect = this.suspectSet.values();
        Set<Suspect> set = new HashSet<>();
        set.addAll(suspect);
        return set;
    }
}