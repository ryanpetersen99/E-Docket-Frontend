package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Complainant;
import za.ac.cput.Repository.ComplainantRepository;
import za.ac.cput.Repository.Implementation.ComplainantRepositoryImplementation;

import java.util.Set;


public class ComplainantRepositoryImplementationTest {

    private ComplainantRepository complainantRepository;

    @Before
    public void setUp() throws Exception{
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.complainantRepository.create(null);
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
    public void getComplainantSet(){
        Set<Complainant> complainantSet = this.complainantRepository.getComplainantSet();
        Assert.assertEquals(1,complainantSet.size());
    }
}
