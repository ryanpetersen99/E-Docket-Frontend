package za.ac.cput.System;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.System.Evidence;
import za.ac.cput.Factory.System.EvidenceFactory;

/**
 * Unit test for simple App.
 */
public class EvidenceFactoryTest
{
    @Test

    public void getEvidence(){

        String evidenceID = "41256";
        String evidenceDetails = "Gun found on scene of Goodman shooting";
        Evidence evidence = EvidenceFactory.getEvidence(evidenceID,evidenceDetails);
        System.out.println(evidence);
        Assert.assertNotNull(evidence.getEvidenceID());
        Assert.assertNotNull(evidence.getEvidenceDetails());
    }
}
