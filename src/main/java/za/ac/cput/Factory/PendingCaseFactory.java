package za.ac.cput.Factory;

import za.ac.cput.Domain.PendingCase;

public class PendingCaseFactory {

    public static PendingCase getPendingCase(String caseID, String caseDetails, int caseNoOfDockets,String dateOpened) {
        return new PendingCase.Builder().caseID(caseID).caseDetails(caseDetails).caseNoOfDockets(caseNoOfDockets).dateOpened(dateOpened).build();
    }
}
