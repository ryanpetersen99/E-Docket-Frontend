package za.ac.cput.ServiceImplementationTests.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.Charge;
import za.ac.cput.Factory.System.ChargeFactory;
import za.ac.cput.Repository.Implementation.System.ChargeRepositoryImplementation;
import za.ac.cput.Repository.System.ChargeRepository;

import java.util.Set;


public class ChargeRepositoryImplementationTest {

    private ChargeRepository chargeRepository;
    private Charge charge;

    public Charge getSavedCharges() {
        Set<Charge> chargeSet = this.chargeRepository.getChargeSet();
        return chargeSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.chargeRepository = ChargeRepositoryImplementation.getRepository();
        this.charge = ChargeFactory.getCharge("Murder",1);
    }

    @Test
    public void create(){
        Charge createdI = this.chargeRepository.create(this.charge);
        System.out.println("Successfully created charge" + "\n" + charge);
        Assert.assertSame(createdI,this.charge);
    }

    @Test
    public void update(){
        int no = 2;
        Charge charge =  new Charge.Builder().copy(getSavedCharges()).noOfChargers(no).build();
        System.out.println("Updating" + "\n" + charge );
        Charge updatedNO = this.chargeRepository.update(charge);
        System.out.println("Updated" + "\n" + updatedNO);
        Assert.assertSame(no,updatedNO.getNoOfCharges());
    }

    @Test
    public void delete(){
        Charge chargeSaved = getSavedCharges();
        this.chargeRepository.delete(getSavedCharges().getNatureOfCharge());
    }

    @Test
    public void read(){
        Charge chargeSaved = getSavedCharges();
        System.out.println("Read charge" + "\n" + chargeSaved.getNatureOfCharge());
        Charge read = this.chargeRepository.read(chargeSaved.getNatureOfCharge());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(chargeSaved,read);
    }

    @Test
    public void getInspectorSet(){
        Set<Charge> chargeSet = this.chargeRepository.getChargeSet();
        System.out.println("List of Charges" + "\n" + chargeSet);
    }
}
