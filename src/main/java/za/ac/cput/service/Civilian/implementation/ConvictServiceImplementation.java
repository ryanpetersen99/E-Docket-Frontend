package za.ac.cput.service.Civilian.implementation;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.repository.Civilian.ConvictRepository;
import za.ac.cput.repository.implementation.Civillian.ConvictRepositoryImplementation;
import za.ac.cput.service.Civilian.ConvictService;

import java.util.Set;

@Service("ConvictServiceImplementation")
public class ConvictServiceImplementation implements ConvictService {

    private static ConvictServiceImplementation convictServiceImplementation = null;
    private ConvictRepository convictRepository;

    private ConvictServiceImplementation() {
        this.convictRepository = ConvictRepositoryImplementation.getRepository();
    }

    public static ConvictServiceImplementation getRepository() {
        if (convictServiceImplementation == null) convictServiceImplementation = new ConvictServiceImplementation();
        return convictServiceImplementation;
    }

    @Override
    public Convict create(Convict convict) {
        return this.convictRepository.create(convict);
    }

    @Override
    public Convict read(String c) {
        return this.convictRepository.read(c);
    }

    @Override
    public Convict update(Convict convict) {
        return this.convictRepository.update(convict);
    }

    @Override
    public void delete(String c) {
        this.convictRepository.delete(c);
    }

    public Set<Convict> getConvictSet() {
        return this.convictRepository.getConvictSet();
    }
}
