package za.ac.cput.Factory;

import za.ac.cput.Domain.Convict;

public class ConvictFactory {

    public static Convict getConvict(String convictID,String convictName,String convictSurname,String natureOfConviction){
        return new Convict.Builder().convictID(convictID).convictName(convictName).convictSurname(convictSurname).natureOfConviction(natureOfConviction).build();
    }
}
