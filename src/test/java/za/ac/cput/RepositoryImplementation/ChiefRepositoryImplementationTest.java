package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Chief;
import za.ac.cput.Repository.ChiefRepository;
import za.ac.cput.Repository.Implementation.ChiefRepositoryImplementation;

import java.util.Set;

public class ChiefRepositoryImplementationTest {

    private ChiefRepository chiefRepository;

    @Before
    public void setUp() throws Exception{
        this.chiefRepository = ChiefRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.chiefRepository.create(null);
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
    public void getChiefSet(){
        Set<Chief> chiefSet = this.chiefRepository.getChiefSet();
        Assert.assertEquals(1,chiefSet.size());
    }
}
