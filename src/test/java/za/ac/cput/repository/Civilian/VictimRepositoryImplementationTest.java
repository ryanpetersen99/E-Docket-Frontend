package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.factory.Civilian.VictimFactory;
import za.ac.cput.repository.implementation.Civillian.VictimRepositoryImplementation;

import java.util.Set;


public class VictimRepositoryImplementationTest {

    private VictimRepository victimRepository;
    private Victim victim;
    private Victim victim2;


    public Victim getSavedVictims() {
        Set<Victim> victimSet = this.victimRepository.getVictimSet();
        return victimSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.victimRepository = VictimRepositoryImplementation.getRepository();
        this.victim = VictimFactory.getVictim("9203125368964", "Casper", "Nyovest", "Committed career suicide");
        this.victim2 = VictimFactory.getVictim("9003125355554", "Areece", "Doe", "Committed suicide");

    }

    @Test
    public void create() {
        Victim createdVictim = this.victimRepository.create(this.victim);
        Victim createdVictim2 = this.victimRepository.create(this.victim2);
        System.out.println("Successfully created victim" + "\n" + createdVictim);
        System.out.println("Successfully created victim 2" + "\n" + createdVictim);
        Assert.assertSame(createdVictim, this.victim);
    }

    @Test
    public void update() {
        String updatedStatement = "Killed by AKA";
        Victim victim = new Victim.Builder().copy(getSavedVictims()).statement(updatedStatement).build();
        Victim updatedVic = this.victimRepository.update(victim);
        System.out.println("Updated" + "\n" + updatedVic);
        Assert.assertSame(updatedStatement, updatedVic.getStatement());
    }

    @Test
    public void delete() {
        Victim victimSaved = getSavedVictims();
        this.victimRepository.delete(victimSaved.getVictimID());
        getVictimSet();
    }

    @Test
    public void read() {
        Victim victimSaved = getSavedVictims();
        Victim read = this.victimRepository.read(victimSaved.getVictimID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(victimSaved, read);
    }

    @Test
    public void getVictimSet() {
        Set<Victim> victimSet = this.victimRepository.getVictimSet();
        System.out.println("List of victims" + "\n" + victimSet);
        Assert.assertEquals(1, victimSet.size());
    }
}
