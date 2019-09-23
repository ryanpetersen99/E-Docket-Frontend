package za.ac.cput.repository.implementation.Civillian;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.repository.Civilian.ConvictRepository;

import java.util.*;

@Repository("ConvictRepository")
public class ConvictRepositoryImplementation implements ConvictRepository {

    private static ConvictRepositoryImplementation conRepImp = null;
    private Map<String, Convict> convictSet;

    private ConvictRepositoryImplementation() {
        this.convictSet = new HashMap<>();
    }

    public static ConvictRepositoryImplementation getRepository() {
        if (conRepImp == null) conRepImp = new ConvictRepositoryImplementation();
        return conRepImp;
    }

//    private Convict findConvict(String convictID) {
//        return this.convictSet.stream()
//                .filter(convict -> convict.getConvictID().trim().equals(convictID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Convict create(Convict convict) {
        if (read(convict.getConvictID()) == null) {
            this.convictSet.put(convict.getConvictID(), convict);
        }
        return convict;
    }

    @Override
    public Convict read(String id) {
        return this.convictSet.get(id);
    }

    @Override
    public Convict update(Convict convict) {
        if (read(convict.getConvictID()) != null) {
            convictSet.replace(convict.getConvictID(), convict);
        }
        return convict;
    }

    @Override
    public void delete(String id) {
        Convict convict = read(id);
        this.convictSet.remove(id, convict);

    }

    public Set<Convict> getConvictSet() {
        Collection<Convict> con = this.convictSet.values();
        Set<Convict> set = new HashSet<>();
        set.addAll(con);
        return set;
    }
}
