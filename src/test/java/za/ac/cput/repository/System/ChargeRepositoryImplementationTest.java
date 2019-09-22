package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.factory.System.ChargeFactory;
import za.ac.cput.repository.implementation.System.ChargeRepositoryImplementation;

import java.util.Set;


public class ChargeRepositoryImplementationTest {

    private ChargeRepository chargeRepository;
    private Charge charge;
    private Charge charge2;

    public Charge getSavedCharges() {
        Set<Charge> chargeSet = this.chargeRepository.getChargeSet();
        return chargeSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.chargeRepository = ChargeRepositoryImplementation.getRepository();
        this.charge = ChargeFactory.getCharge("Murder", 1);
        this.charge2 = ChargeFactory.getCharge("Rape,Murder", 1);
    }

    @Test
    public void create() {
        Charge createdI = this.chargeRepository.create(this.charge);
        Charge createdI2 = this.chargeRepository.create(this.charge2);
        System.out.println("Successfully created charge" + "\n" + charge);
        System.out.println("Successfully created charge 2" + "\n" + charge2);
        Assert.assertSame(createdI, this.charge);
        Assert.assertSame(createdI2, this.charge2);
    }

    @Test
    public void update() {
        int no = 2;
        Charge charge = new Charge.Builder().copy(getSavedCharges()).noOfChargers(no).build();
        Charge updatedNO = this.chargeRepository.update(charge);
        System.out.println("Updated" + "\n" + updatedNO);
        Assert.assertSame(no, updatedNO.getNoOfCharges());
    }

    @Test
    public void delete() {
        Charge chargeSaved = getSavedCharges();
        this.chargeRepository.delete(chargeSaved.getNatureOfCharge());
        getChargeSet();
    }

    @Test
    public void read() {
        Charge chargeSaved = getSavedCharges();
        Charge read = this.chargeRepository.read(chargeSaved.getNatureOfCharge());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(chargeSaved, read);
    }

    @Test
    public void getChargeSet() {
        Set<Charge> chargeSet = this.chargeRepository.getChargeSet();
        System.out.println("List of Charges" + "\n" + chargeSet);
        Assert.assertEquals(1, chargeSet.size());
    }
}
