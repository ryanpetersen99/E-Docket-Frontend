package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Civillian.Complainant;
import za.ac.cput.Repository.Civillian.ComplainantRepository;
import za.ac.cput.Repository.Implementation.Civillian.ComplainantRepositoryImplementation;
import za.ac.cput.Service.Civillian.ComplainantService;

import java.util.Set;

public class ComplainantServiceImplementation implements ComplainantService{

    private static ComplainantServiceImplementation compService = null;
    private ComplainantRepository complainantRepository;

    private ComplainantServiceImplementation(){
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
    }

    public static ComplainantServiceImplementation getCompService(){
        if(compService == null)compService = new ComplainantServiceImplementation();
        return compService;
    }

    @Override
    public Complainant create(Complainant complainant) {
        return this.complainantRepository.create(complainant);
    }

    @Override
    public Complainant read(String c) {
        return this.complainantRepository.read(c);
    }

    @Override
    public Complainant update(Complainant complainant) {
        return this.complainantRepository.update(complainant);
    }

    @Override
    public void delete(String c) {
        this.complainantRepository.delete(c);
    }

    public Set<Complainant> getComplainantSet() {
        return this.complainantRepository.getComplainantSet();
    }
}
