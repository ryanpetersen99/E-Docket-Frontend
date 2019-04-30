package za.ac.cput.Service.Implementation;



import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Repository.Civillian.ConvictRepository;
import za.ac.cput.Repository.Implementation.Civillian.ConvictRepositoryImplementation;
import za.ac.cput.Service.Civillian.ConvictService;

import java.util.Set;

public class ConvictServiceImplementation implements ConvictService{

    private static ConvictServiceImplementation convictServiceImplementation = null;
    private ConvictRepository convictRepository;

    private ConvictServiceImplementation(){
        this.convictRepository = ConvictRepositoryImplementation.getRepository();
    }

    public static ConvictServiceImplementation getRepository(){
        if(convictServiceImplementation == null)convictServiceImplementation = new ConvictServiceImplementation();
        return convictServiceImplementation;
    }

    @Override
    public Convict create(Convict convict) {return this.convictRepository.create(convict);}

    @Override
    public Convict read(String c) {
        return this.convictRepository.read(c);
    }

    @Override
    public Convict update(Convict convict) {
        return this.convictRepository.update(convict);
    }

    @Override
    public void delete(String c) {this.convictRepository.delete(c); }

    public Set<Convict> getConvictSet() {
        return this.convictRepository.getConvictSet();
    }
}
