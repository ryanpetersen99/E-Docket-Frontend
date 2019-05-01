package za.ac.cput.ServiceImplementationTests.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Civilian.Victim;
import za.ac.cput.Factory.Civilian.VictimFactory;
import za.ac.cput.Repository.Civilian.VictimRepository;
import za.ac.cput.Repository.Implementation.Civillian.VictimRepositoryImplementation;

import java.util.Set;


public class VictimRepositoryServiceTest {

    private VictimRepository victimRepository;
    private Victim victim;


    public Victim getSavedVictims() {
        Set<Victim> victimSet = this.victimRepository.getVictimSet();
        return victimSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.victimRepository = VictimRepositoryImplementation.getRepository();
        this.victim = VictimFactory.getVictim("9203125368964","Casper","Nyovest","Committed career suicide");

    }

    @Test
    public void create(){
        Victim createdVictim = this.victimRepository.create(this.victim);
        System.out.println("Successfully created victim" + "\n" + createdVictim);
        Assert.assertSame(createdVictim,this.victim);
    }

    @Test
    public void update(){
        String updatedStatement = "Killed by AKA";
        Victim victim =  new Victim.Builder().copy(getSavedVictims()).statement(updatedStatement).build();
        System.out.println("Updating" + "\n" + victim );
        Victim updatedVic = this.victimRepository.update(victim);
        System.out.println("Updated" + "\n" + updatedVic);
        Assert.assertSame(updatedStatement,updatedVic.getStatement());
    }

    @Test
    public void delete(){
        Victim victimSaved = getSavedVictims();
        this.victimRepository.delete(victimSaved.getVictimID());
    }

    @Test
    public void read(){
        Victim victimSaved = getSavedVictims();
        System.out.println("Read victim ID number" + "\n" + victimSaved.getVictimID());
        Victim read = this.victimRepository.read(victimSaved.getVictimID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(victimSaved,read);
    }

    @Test
    public void getVictimSet(){
        Set<Victim> victimSet = this.victimRepository.getVictimSet();
        System.out.println("List of complainants" + "\n" + victimSet);
        //     Assert.assertEquals(1,complainantSet.size());
    }
}
