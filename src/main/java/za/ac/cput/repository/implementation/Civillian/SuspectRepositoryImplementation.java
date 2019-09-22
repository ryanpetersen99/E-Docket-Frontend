package za.ac.cput.repository.implementation.Civillian;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.repository.Civilian.SuspectRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("SuspectRepository")
public class SuspectRepositoryImplementation implements SuspectRepository {

    private static SuspectRepositoryImplementation suspectRepImp = null;
    private Set<Suspect> suspectSet;

    private SuspectRepositoryImplementation() {
        this.suspectSet = new HashSet<>();
    }

    private Suspect findSuspect(String suspectID) {
        return this.suspectSet.stream()
                .filter(suspect -> suspect.getSuspectID().trim().equals(suspectID))
                .findAny()
                .orElse(null);
    }

    public static SuspectRepositoryImplementation getRepository() {
        if (suspectRepImp == null) suspectRepImp = new SuspectRepositoryImplementation();
        return suspectRepImp;
    }

    @Override
    public Suspect create(Suspect suspect) {
        this.suspectSet.add(suspect);
        return suspect;
    }

    @Override
    public Suspect read(String suspectID) {
        return findSuspect(suspectID);
    }

    @Override
    public Suspect update(Suspect suspect) {
        Suspect delete = findSuspect(suspect.getSuspectID());
        if (delete != null) {
            this.suspectSet.remove(delete);
            return create(suspect);
        }
        return null;
    }

    @Override
    public void delete(String suspectID) {
        Suspect suspect = findSuspect(suspectID);
        if (suspect != null) {
            this.suspectSet.remove(suspect);
        }

    }

    public Set<Suspect> getSuspectSet() {
        return this.suspectSet;
    }
}
