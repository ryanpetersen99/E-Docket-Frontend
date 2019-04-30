package za.ac.cput.Repository.Implementation.System;



import za.ac.cput.Domain.System.Charge;
import za.ac.cput.Repository.System.ChargeRepository;

import java.util.HashSet;
import java.util.Set;

public class ChargeRepositoryImplementation implements ChargeRepository{

    private static ChargeRepositoryImplementation chargeRepositoryImplementation = null;
    private Set<Charge> chargeSet;

    private ChargeRepositoryImplementation(){
        this.chargeSet = new HashSet<>();
    }

    private Charge findCharge(String chargeDetails){
        return  this.chargeSet.stream()
                .filter(charge -> charge.getNatureOfCharge().trim().equals(chargeDetails))
                .findAny()
                .orElse(null);
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
        return findCharge(natureOfCharge);
    }

    @Override
    public Charge update(Charge charge) {
        Charge delete = findCharge(charge.getNatureOfCharge());
        if(delete != null){
            this.chargeSet.remove(delete);
            return create(charge);
        }
        return null;
    }

    @Override
    public void delete(String natureOfCharge) {
        Charge charge = findCharge(natureOfCharge);
        if(natureOfCharge != null) {
            this.chargeSet.remove(charge);
        }
    }

    public Set<Charge> getChargeSet() {
        return this.chargeSet;
    }
}
