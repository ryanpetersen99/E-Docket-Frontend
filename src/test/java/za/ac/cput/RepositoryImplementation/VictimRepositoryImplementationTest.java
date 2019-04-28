package za.ac.cput.RepositoryImplementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.SolvedCase;
import za.ac.cput.Domain.Victim;
import za.ac.cput.Repository.Implementation.SolvedCaseRepositoryImplementation;
import za.ac.cput.Repository.Implementation.VictimRepositoryImplementation;
import za.ac.cput.Repository.SolvedCaseRepository;
import za.ac.cput.Repository.VictimRepository;

import java.util.Set;


public class VictimRepositoryImplementationTest {

    private VictimRepository victimRepository;

    @Before
    public void setUp() throws Exception{
        this.victimRepository = VictimRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.victimRepository.create(null);
        Assert.assertEquals(null,null);
    }

    @Test
    public void update(){

    }

    @Test
    public void delete(){
    }

    @Test
    public void read(){

    }

    @Test
    public void getVicyimSet(){
        Set<Victim> victims = this.victimRepository.getVictimSet();
        Assert.assertEquals(1,victims.size());
    }
}
