package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Officer;
import za.ac.cput.Repository.Implementation.OfficerRepositoryImplementation;
import za.ac.cput.Repository.OfficerRepository;

import java.util.Set;

public class OfficerRepositoryImplementationTest {

    private OfficerRepository officerRepository;

    @Before
    public void setUp() throws Exception{
        this.officerRepository = OfficerRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.officerRepository.create(null);
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
    public void getOfficerSet(){
        Set<Officer> officerSet = this.officerRepository.getOfficerSet();
        Assert.assertEquals(1,officerSet.size());
    }
}
