package za.ac.cput.Factory;

import za.ac.cput.Domain.Case;

public class CaseFactory {

    public static Case getCase(String caseID, String caseDetails, Integer caseNoOfDockets) {
        return new Case.Builder().caseID(caseID).caseDetails(caseDetails).caseNoOfDockets(caseNoOfDockets).build();
    }
}
