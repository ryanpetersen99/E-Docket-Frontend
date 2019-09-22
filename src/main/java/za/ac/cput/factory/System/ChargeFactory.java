package za.ac.cput.factory.System;

import za.ac.cput.domain.System.Charge;

public class ChargeFactory {

    public static Charge
    getCharge(String natureOfCharge, int noOfCharges) {
        return new Charge.Builder().natureOfCharge(natureOfCharge).noOfChargers(noOfCharges).build();
    }
}
