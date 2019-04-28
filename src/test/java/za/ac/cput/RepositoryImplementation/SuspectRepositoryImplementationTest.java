package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Suspect;
import za.ac.cput.Repository.Implementation.SuspectRepositoryImplementation;
import za.ac.cput.Repository.SuspectRepository;

import java.util.Set;


public class SuspectRepositoryImplementationTest {

    private SuspectRepository suspectRepository;

    @Before
    public void setUp() throws Exception{
        this.suspectRepository = SuspectRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.suspectRepository.create(null);
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
    public void getSuspectSet(){
        Set<Suspect> suspectSet = this.suspectRepository.getSuspectSet();
        Assert.assertEquals(1,suspectSet.size());
    }
}
