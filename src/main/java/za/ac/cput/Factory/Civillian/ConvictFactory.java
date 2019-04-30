package za.ac.cput.Factory.Civillian;

import za.ac.cput.Domain.Civillian.Convict;

public class ConvictFactory {

    public static Convict getConvict(String convictID,String convictName,String convictSurname,String natureOfConviction){
        return new Convict.Builder().convictID(convictID).convictName(convictName).convictSurname(convictSurname).natureOfConviction(natureOfConviction).build();
    }
}
