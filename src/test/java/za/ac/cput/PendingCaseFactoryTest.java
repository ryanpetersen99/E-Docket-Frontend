package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.PendingCase;
import za.ac.cput.Domain.SolvedCase;
import za.ac.cput.Factory.PendingCaseFactory;
import za.ac.cput.Factory.SolvedCaseFactory;

/**
 * Unit test for simple App.
 */
public class PendingCaseFactoryTest
{
    @Test

    public void getCase(){

        String caseID = "11244";
        String caseDetails = "Case opened by Mr. Van De Merve with accusation of assualt against Mr. Shaw";
        Integer caseNoOfDockets = 2;
        String dateOpened = "12 May 13";
        PendingCase pendingCase = PendingCaseFactory.getPendingCase(caseID,caseDetails,caseNoOfDockets,dateOpened);

        System.out.println(pendingCase);
        Assert.assertNotNull(pendingCase.getCaseID());
        Assert.assertNotNull(pendingCase.getCaseDetails());
        Assert.assertNotNull(pendingCase.getCaseNoOfDockets());
        Assert.assertNotNull(pendingCase.getDateOpened());


    }
}
