package za.ac.cput.Factory.Civilian;

import za.ac.cput.Domain.Civilian.Complainant;

public class ComplainantFactory {

    public static Complainant getComplainant(String complainantID,String complainantName,String complainantSurname,String complainantStatement){
        return new Complainant.Builder().complainantID(complainantID).complainantName(complainantName).complainantSurname(complainantSurname).complainantStatement(complainantStatement).build();
    }
}
