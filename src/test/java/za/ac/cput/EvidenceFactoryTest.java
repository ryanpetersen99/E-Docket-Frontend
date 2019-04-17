package za.ac.cput;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Docket;
import za.ac.cput.Domain.Evidence;
import za.ac.cput.Factory.DocketFactory;
import za.ac.cput.Factory.EvidenceFactory;

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
