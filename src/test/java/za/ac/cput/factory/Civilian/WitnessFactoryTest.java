package za.ac.cput.factory.Civilian;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Witness;

/**
 * Unit test for simple App.
 */
public class WitnessFactoryTest {
    @Test

    public void getWitness() {

        String witnessID = "8402117457697";
        String witnessName = "Trent";
        String witnessSurname = "Arnold";
        String witnessStatement = "Witnessed the complainant getting assualted";

        Witness witness = WitnessFactory.getWitness(witnessID, witnessName, witnessSurname, witnessStatement);
        System.out.println(witness);
        Assert.assertNotNull(witness.getWitnessID());
        Assert.assertNotNull(witness.getWitnessName());
        Assert.assertNotNull(witness.getWitnessSurname());
        Assert.assertNotNull(witness.getWitnessStatement());
    }
}
