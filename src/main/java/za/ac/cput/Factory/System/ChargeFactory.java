package za.ac.cput.Factory.System;

import za.ac.cput.Domain.System.Charge;

public class ChargeFactory {

    public static Charge
    getCharge(String natureOfCharge, int noOfCharges){
        return new Charge.Builder().natureOfCharge(natureOfCharge).noOfChargers(noOfCharges).build();
    }
}
