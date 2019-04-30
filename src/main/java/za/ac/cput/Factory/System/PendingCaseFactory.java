package za.ac.cput.Factory.System;

import za.ac.cput.Domain.System.PendingCase;

public class PendingCaseFactory {

    public static PendingCase getPendingCase(String caseID, String caseDetails, int caseNoOfDockets,String dateOpened) {
        return new PendingCase.Builder().caseID(caseID).caseDetails(caseDetails).caseNoOfDockets(caseNoOfDockets).dateOpened(dateOpened).build();
    }
}
