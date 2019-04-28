package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Docket;
import za.ac.cput.Repository.DocketRepository;
import za.ac.cput.Repository.Implementation.DocketRepositoryImplementation;

import java.util.Set;


public class DocketRepositoryImplementationTest {

    private DocketRepository docketRepository;

    @Before
    public void setUp() throws Exception{
        this.docketRepository = DocketRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.docketRepository.create(null);
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
        Set<Docket> docketSet = this.docketRepository.getDocketSet();
        Assert.assertEquals(1,docketSet.size());
    }
}
