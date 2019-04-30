package za.ac.cput.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Factory.System.SolvedCaseFactory;

/**
 * Unit test for simple App.
 */
public class SolvedCaseFactoryTest
{
    @Test

    public void getCase(){

        String caseID = "11244";
        String caseDetails = "Case opened by Mr. Van De Merve with accusation of assualt against Mr. Shaw";
        Integer caseNoOfDockets = 2;
        String dateSolved = "12 May 12";
        SolvedCase casetest = SolvedCaseFactory.getSolvedCase(caseID,caseDetails,caseNoOfDockets,dateSolved);

        System.out.println(casetest);
        Assert.assertNotNull(casetest.getCaseID());
        Assert.assertNotNull(casetest.getCaseDetails());
        Assert.assertNotNull(casetest.getCaseNoOfDockets());
        Assert.assertNotNull(casetest.getDateSolved());


    }
}
