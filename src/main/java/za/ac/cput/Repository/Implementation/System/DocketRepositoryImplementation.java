package za.ac.cput.Repository.Implementation.System;

import za.ac.cput.Domain.System.Docket;
import za.ac.cput.Repository.System.DocketRepository;

import java.util.HashSet;
import java.util.Set;

public class DocketRepositoryImplementation implements DocketRepository{

    private static DocketRepositoryImplementation docketRepImp = null;
    private Set<Docket> docketSet;

    private DocketRepositoryImplementation(){
        this.docketSet = new HashSet<>();
    }


    private Docket findDocket(String docketID){
        return  this.docketSet.stream()
                .filter(docket -> docket.getDocketID().trim().equals(docketID))
                .findAny()
                .orElse(null);
    }

    public static DocketRepositoryImplementation getRepository(){
        if(docketRepImp == null)docketRepImp = new DocketRepositoryImplementation();
        return docketRepImp;
    }

    @Override
    public Docket create(Docket docket) {
        this.docketSet.add(docket);
        return docket;
    }

    @Override
    public Docket read(String docketID) {
        return findDocket(docketID);
    }

    @Override
    public Docket update(Docket docket) {
        Docket delete = findDocket(docket.getDocketID());
        if(delete != null){
            this.docketSet.remove(delete);
            return create(docket);
        }
        return null;
    }

    @Override
    public void delete(String docketID) {
        Docket docket = findDocket(docketID);
        if(docket != null) {
            this.docketSet.remove(docket);
        }
    }

    public Set<Docket> getDocketSet() {
        return this.docketSet;
    }
}
