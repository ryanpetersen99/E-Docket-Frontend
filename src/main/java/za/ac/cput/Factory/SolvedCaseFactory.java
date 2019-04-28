package za.ac.cput.Factory;

import za.ac.cput.Domain.SolvedCase;

public class SolvedCaseFactory {

    public static SolvedCase getSolvedCase(String caseID, String caseDetails, int caseNoOfDockets,String dateSolved) {
        return new SolvedCase.Builder().caseID(caseID).caseDetails(caseDetails).caseNoOfDockets(caseNoOfDockets).dateSolved(dateSolved).build();
    }
}
