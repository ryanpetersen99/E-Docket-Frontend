package za.ac.cput.Factory.Civillian;

import za.ac.cput.Domain.Civillian.Witness;

public class WitnessFactory {

    public static Witness getWitness(String witnessID,String witnessName, String witnessSurname, String witnessStatement){
        return new Witness.Builder().witnessID(witnessID).witnessName(witnessName).witnessSurname(witnessSurname).witnessStatement(witnessStatement).build();
    }
}
