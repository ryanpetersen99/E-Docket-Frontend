package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Witness;
import za.ac.cput.Repository.Implementation.WitnessRepositoryImplementation;
import za.ac.cput.Repository.WitnessRepository;

import java.util.Set;


public class WitnessRepositoryImplementationTest {

    private WitnessRepository witnessRepository;

    @Before
    public void setUp() throws Exception{
        this.witnessRepository = WitnessRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.witnessRepository.create(null);
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
    public void getWitnessSet(){
        Set<Witness> witnessSet = this.witnessRepository.getWitnessSet();
        Assert.assertEquals(1,witnessSet.size());
    }
}
