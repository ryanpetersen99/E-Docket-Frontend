package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Civillian.Victim;
import za.ac.cput.Repository.Implementation.Civillian.VictimRepositoryImplementation;
import za.ac.cput.Repository.Civillian.VictimRepository;
import za.ac.cput.Service.Civillian.VictimService;

import java.util.Set;

public class VictimServiceImplementation implements VictimService{

    private static VictimServiceImplementation victimServiceImplementation = null;
    private VictimRepository victimRepository;

    private VictimServiceImplementation(){
        this.victimRepository = VictimRepositoryImplementation.getRepository();
    }

    public static VictimServiceImplementation getRepository(){
        if(victimServiceImplementation == null)victimServiceImplementation = new VictimServiceImplementation();
        return victimServiceImplementation;
    }

    @Override
    public Victim create(Victim victim) {return this.victimRepository.create(victim); }

    @Override
    public Victim read(String v) {
        return this.victimRepository.read(v);
    }

    @Override
    public Victim update(Victim victim) {
        return this.victimRepository.update(victim);
    }

    @Override
    public void delete(String v) { this.victimRepository.delete(v);}

    public Set<Victim> getVictimSet() {
        return this.victimRepository.getVictimSet();
    }
}
