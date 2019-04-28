package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Suspect;
import za.ac.cput.Repository.SuspectRepository;

import java.util.HashSet;
import java.util.Set;

public class SuspectRepositoryImplementation implements SuspectRepository{

    private static SuspectRepositoryImplementation suspectRepImp = null;
    private Set<Suspect> suspectSet;

    private SuspectRepositoryImplementation(){
        this.suspectSet = new HashSet<>();
    }

    public static SuspectRepositoryImplementation getRepository(){
        if(suspectRepImp == null)suspectRepImp = new SuspectRepositoryImplementation();
        return suspectRepImp;
    }

    @Override
    public Suspect create(Suspect suspect) {
        this.suspectSet.add(suspect);
        return suspect;
    }

    @Override
    public Suspect read(String suspectID) {
        return null;
    }

    @Override
    public Suspect update(Suspect suspect) {
        return suspect;
    }

    @Override
    public void delete(String suspectID) {

    }

    public Set<Suspect> getSuspectSet() {
        return this.suspectSet;
    }
}
