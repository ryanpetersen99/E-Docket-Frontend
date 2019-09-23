package za.ac.cput.repository.implementation.System;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Docket;
import za.ac.cput.repository.System.DocketRepository;

import java.util.*;

@Repository("DocketRepository")
public class DocketRepositoryImplementation implements DocketRepository {

    private static DocketRepositoryImplementation compRepImp = null;
    private Map<String, Docket> docketSet;

    private DocketRepositoryImplementation() {
        this.docketSet = new HashMap<>();
    }

    public static DocketRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new DocketRepositoryImplementation();
        return compRepImp;
    }

//    private Docket findDocket(String docketID) {
//        return this.docketSet.stream()
//                .filter(docket -> docket.getDocketID().trim().equals(docketID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Docket create(Docket docket) {
        if (read(docket.getDocketID()) == null) {
            this.docketSet.put(docket.getDocketID(), docket);
        }
        return docket;
    }

    @Override
    public Docket read(String id) {
        return this.docketSet.get(id);
    }

    @Override
    public Docket update(Docket docket) {
        if (read(docket.getDocketID()) != null) {
            docketSet.replace(docket.getDocketID(), docket);
        }
        return docket;
    }

    @Override
    public void delete(String id) {
        Docket docket = read(id);
        this.docketSet.remove(id, docket);

    }

    public Set<Docket> getDocketSet() {
        Collection<Docket> docket = this.docketSet.values();
        Set<Docket> set = new HashSet<>();
        set.addAll(docket);
        return set;
    }
}