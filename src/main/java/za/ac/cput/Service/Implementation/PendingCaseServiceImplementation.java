package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.PendingCase;
import za.ac.cput.Repository.Implementation.PendingCaseRepositoryImplementation;
import za.ac.cput.Repository.PendingCaseRepository;
import za.ac.cput.Service.PendingCaseService;

import java.util.HashSet;
import java.util.Set;

public class PendingCaseServiceImplementation implements PendingCaseService {

    private static PendingCaseServiceImplementation pendingCaseServiceImplementation = null;
    private PendingCaseRepository pendingCaseRepository;

    private PendingCaseServiceImplementation(){
        this.pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
    }

    public static PendingCaseServiceImplementation getRepository(){
        if(pendingCaseServiceImplementation == null)pendingCaseServiceImplementation = new PendingCaseServiceImplementation();
        return pendingCaseServiceImplementation;
    }

    @Override
    public PendingCase create(PendingCase pendingCase) {return this .pendingCaseRepository.create(pendingCase);}

    @Override
    public PendingCase read(String c) { return this.pendingCaseRepository.read(c); }

    @Override
    public PendingCase update(PendingCase pendingCase) { return this.pendingCaseRepository.update(pendingCase); }

    @Override
    public void delete(String c) { this.delete(c);}

    public Set<PendingCase> getPendingCaseSet() { return this.pendingCaseRepository.getPendingCaseSet(); }
}
