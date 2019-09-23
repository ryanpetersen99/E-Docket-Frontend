package za.ac.cput.repository.implementation.System;


import org.springframework.stereotype.Repository;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.repository.System.ChargeRepository;

import java.util.*;

@Repository("ChargeRepository")
public class ChargeRepositoryImplementation implements ChargeRepository {

    private static ChargeRepositoryImplementation compRepImp = null;
    private Map<String, Charge> chargeSet;

    private ChargeRepositoryImplementation() {
        this.chargeSet = new HashMap<>();
    }

    public static ChargeRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new ChargeRepositoryImplementation();
        return compRepImp;
    }

//    private Charge findCharge(String chargeID) {
//        return this.chargeSet.stream()
//                .filter(charge -> charge.getChargeID().trim().equals(chargeID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public Charge create(Charge charge) {
        if (read(charge.getNatureOfCharge()) == null) {
            this.chargeSet.put(charge.getNatureOfCharge(), charge);
        }
        return charge;
    }

    @Override
    public Charge read(String id) {
        return this.chargeSet.get(id);
    }

    @Override
    public Charge update(Charge charge) {
        if (read(charge.getNatureOfCharge()) != null) {
            chargeSet.replace(charge.getNatureOfCharge(), charge);
        }
        return charge;
    }

    @Override
    public void delete(String id) {
        Charge charge = read(id);
        this.chargeSet.remove(id, charge);

    }

    public Set<Charge> getChargeSet() {
        Collection<Charge> charge = this.chargeSet.values();
        Set<Charge> set = new HashSet<>();
        set.addAll(charge);
        return set;
    }
}