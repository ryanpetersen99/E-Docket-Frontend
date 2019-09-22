package za.ac.cput.factory.System;

import za.ac.cput.domain.System.SolvedCase;

public class SolvedCaseFactory {

    public static SolvedCase getSolvedCase(String caseID, String caseDetails, int caseNoOfDockets, String dateSolved) {
        return new SolvedCase.Builder().caseID(caseID).caseDetails(caseDetails).caseNoOfDockets(caseNoOfDockets).dateSolved(dateSolved).build();
    }
}
