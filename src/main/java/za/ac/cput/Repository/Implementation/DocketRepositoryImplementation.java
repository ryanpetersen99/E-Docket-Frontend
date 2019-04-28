package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.Docket;
import za.ac.cput.Repository.DocketRepository;

import java.util.HashSet;
import java.util.Set;

public class DocketRepositoryImplementation implements DocketRepository{

    private static DocketRepositoryImplementation docketRepImp = null;
    private Set<Docket> docketSet;

    private DocketRepositoryImplementation(){
        this.docketSet = new HashSet<>();
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
        return null;
    }

    @Override
    public Docket update(Docket docket) {
        return docket;
    }

    @Override
    public void delete(String docketID) {

    }

    public Set<Docket> getDocketSet() {
        return this.docketSet;
    }
}
