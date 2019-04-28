package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Administrator;
import za.ac.cput.Domain.Charge;
import za.ac.cput.Repository.AdministratorRepository;
import za.ac.cput.Repository.ChargeRepository;
import za.ac.cput.Repository.Implementation.AdministratorRepositoryImplementation;
import za.ac.cput.Repository.Implementation.ChargeRepositoryImplementation;

import java.util.Set;


public class ChargeRepositoryImplementationTest {

    private ChargeRepository chargeRepository;

    @Before
    public void setUp() throws Exception{
        this.chargeRepository = ChargeRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.chargeRepository.create(null);
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
    public void getChargeSet(){
        Set<Charge> chargeSet = this.chargeRepository.getChargeSet();
        Assert.assertEquals(1,chargeSet.size());
    }
}
