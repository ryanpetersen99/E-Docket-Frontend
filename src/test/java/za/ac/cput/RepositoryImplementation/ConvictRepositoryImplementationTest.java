package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Charge;
import za.ac.cput.Domain.Convict;
import za.ac.cput.Repository.ChargeRepository;
import za.ac.cput.Repository.ConvictRepository;
import za.ac.cput.Repository.Implementation.ChargeRepositoryImplementation;
import za.ac.cput.Repository.Implementation.ConvictRepositoryImplementation;

import java.util.Set;


public class ConvictRepositoryImplementationTest {

    private ConvictRepository convictRepository;

    @Before
    public void setUp() throws Exception{
        this.convictRepository = ConvictRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.convictRepository.create(null);
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
    public void getConvictSet(){
        Set<Convict> convict = this.convictRepository.getConvictSet();
        Assert.assertEquals(1,convict.size());
    }
}
