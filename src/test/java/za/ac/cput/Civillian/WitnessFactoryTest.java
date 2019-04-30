package za.ac.cput.Civillian;

import org.junit.Assert;
import org.junit.Test;
import za.ac.cput.Domain.Civillian.Witness;
import za.ac.cput.Factory.Civillian.WitnessFactory;

/**
 * Unit test for simple App.
 */
public class WitnessFactoryTest
{
    @Test

    public void getWitness(){

        String witnessID = "8402117457697";
        String witnessName = "Trent";
        String witnessSurname = "Arnold";
        String witnessStatement = "Witnessed the complainant getting assualted";

        Witness witness = WitnessFactory.getWitness(witnessID,witnessName,witnessSurname,witnessStatement);
        System.out.println(witness);
        Assert.assertNotNull(witness.getWitnessID());
        Assert.assertNotNull(witness.getWitnessName());
        Assert.assertNotNull(witness.getWitnessSurname());
        Assert.assertNotNull(witness.getWitnessStatement());
    }
}
