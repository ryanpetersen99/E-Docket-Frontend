package za.ac.cput.service.Civilian.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.repository.Civilian.ComplainantRepository;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;
import za.ac.cput.service.Civilian.ComplainantService;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service("complainantServiceImplementation")
public class ComplainantServiceImplementation implements ComplainantService {

    private static List<Complainant> complainantList = new ArrayList<>();

    static {
        complainantList.add(new Complainant("1", "Ryan",  "Petersen" ,"Learn Full stack with Spring Boot and Angular"));
        complainantList.add(new Complainant("2", "Ryan", "Petersen" ,"Learn Full stack with Spring Boot and React"));
        complainantList.add(new Complainant("3", "Ryan", "Petersen" ,"Master Microservices with Spring Boot and Spring Cloud"));
        complainantList.add(new Complainant("4", "Ryan", "Petersen"  ,"Deploy Spring Boot Microservices to Cloud with Docker and Kubernetes"));
    }

    public List<Complainant> findAll() {
        return complainantList;
    }

    private static ComplainantServiceImplementation compService = null;
    private ComplainantRepository complainantRepository;

    private ComplainantServiceImplementation() {
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
    }

    public static ComplainantServiceImplementation getCompService() {
        if (compService == null) compService = new ComplainantServiceImplementation();
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

    @Override
    public Set<Complainant> getAll() {
        return this.complainantRepository.getComplainantSet();
    }
}
