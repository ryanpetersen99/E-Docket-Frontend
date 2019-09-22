package za.ac.cput.factory.Civilian;

import za.ac.cput.domain.Civilian.Complainant;

public class ComplainantFactory {

    public static Complainant getComplainant(String complainantID, String complainantName, String complainantSurname, String complainantStatement) {
        return new Complainant.Builder().complainantID(complainantID).complainantName(complainantName).complainantSurname(complainantSurname).complainantStatement(complainantStatement).build();
    }
}
