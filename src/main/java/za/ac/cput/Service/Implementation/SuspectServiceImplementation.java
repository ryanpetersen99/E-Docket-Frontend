package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Suspect;
import za.ac.cput.Repository.Implementation.SuspectRepositoryImplementation;
import za.ac.cput.Repository.SuspectRepository;
import za.ac.cput.Service.SuspectService;

import java.util.HashSet;
import java.util.Set;

public class SuspectServiceImplementation implements SuspectService{

    private static SuspectServiceImplementation suspectService = null;
    private SuspectRepository suspectRepository;

    private SuspectServiceImplementation(){ this.suspectRepository = SuspectRepositoryImplementation.getRepository(); }

    public static SuspectServiceImplementation getSuspectService(){
        if(suspectService == null)suspectService = new SuspectServiceImplementation();
        return suspectService;
    }

    @Override
    public Suspect create(Suspect suspect) {return this.create(suspect); }

    @Override
    public Suspect read(String s) {
        return this.read(s);
    }

    @Override
    public Suspect update(Suspect suspect) {
        return this.update(suspect);
    }

    @Override
    public void delete(String s) { this.delete(s);}

    public Set<Suspect> getSuspectSet() {
        return this.suspectRepository.getSuspectSet();
    }
}
