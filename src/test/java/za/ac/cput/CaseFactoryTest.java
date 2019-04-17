package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Case;
import za.ac.cput.Domain.Docket;
import za.ac.cput.Factory.CaseFactory;
import za.ac.cput.Factory.DocketFactory;

/**
 * Unit test for simple App.
 */
public class CaseFactoryTest
{
    @Test

    public void getCase(){

        String caseID = "11244";
        String caseDetails = "Case opened by Mr. Van De Merve with accusation of assualt against Mr. Shaw";
        Integer caseNoOfDockets = 2;
        Case casetest = CaseFactory.getCase(caseID,caseDetails,caseNoOfDockets);
        System.out.println(casetest);
        Assert.assertNotNull(casetest.getCaseID());
        Assert.assertNotNull(casetest.getCaseDetails());
        Assert.assertNotNull(casetest.getCaseNoOfDockets());


    }
}
