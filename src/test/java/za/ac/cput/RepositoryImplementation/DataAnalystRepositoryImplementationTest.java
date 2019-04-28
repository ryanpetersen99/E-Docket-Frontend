package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.DataAnalyst;
import za.ac.cput.Repository.DataAnalystRepository;
import za.ac.cput.Repository.Implementation.DataAnalystRepositoryImplementation;

import java.util.Set;


public class DataAnalystRepositoryImplementationTest {

    private DataAnalystRepository dataAnalystRepository;

    @Before
    public void setUp() throws Exception{
        this.dataAnalystRepository = DataAnalystRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.dataAnalystRepository.create(null);
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
    public void getDataAnalystSet(){
        Set<DataAnalyst> dataAnalystSet = this.dataAnalystRepository.getDataAnalystSet();
        Assert.assertEquals(0,dataAnalystSet.size());
    }
}
