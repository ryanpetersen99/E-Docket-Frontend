package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Administrator;
import za.ac.cput.Repository.AdministratorRepository;
import za.ac.cput.Repository.Implementation.AdministratorRepositoryImplementation;

import java.util.Set;


public class AdministratorRepositoryImplementationTest {

    private AdministratorRepository administratorRepository;

    @Before
    public void setUp() throws Exception{
        this.administratorRepository = AdministratorRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.administratorRepository.create(null);
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
    public void getDocketSet(){
        Set<Administrator> administratorSet = this.administratorRepository.getAdministratorSet();
        Assert.assertEquals(1,administratorSet.size());
    }
}
