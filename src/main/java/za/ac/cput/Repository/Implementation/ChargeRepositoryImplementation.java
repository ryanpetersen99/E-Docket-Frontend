package za.ac.cput.Repository.Implementation;



import za.ac.cput.Domain.Charge;
import za.ac.cput.Repository.ChargeRepository;

import java.util.HashSet;
import java.util.Set;

public class ChargeRepositoryImplementation implements ChargeRepository{

    private static ChargeRepositoryImplementation chargeRepositoryImplementation = null;
    private Set<Charge> chargeSet;

    private ChargeRepositoryImplementation(){
        this.chargeSet = new HashSet<>();
    }

    public static ChargeRepositoryImplementation getRepository(){
        if(chargeRepositoryImplementation == null)chargeRepositoryImplementation = new ChargeRepositoryImplementation();
        return chargeRepositoryImplementation;
    }

    @Override
    public Charge create(Charge charge) {
        this.chargeSet.add(charge);
        return charge;
    }

    @Override
    public Charge read(String natureOfCharge) {
        return null;
    }

    @Override
    public Charge update(Charge charge) {
        return charge;
    }

    @Override
    public void delete(String natureOfCharge) {

    }

    public Set<Charge> getChargeSet() {
        return this.chargeSet;
    }
}
