package za.ac.cput.RepositoryImplementationTests.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.DataAnalyst;
import za.ac.cput.Factory.Police.DataAnalystFactory;
import za.ac.cput.Repository.Police.DataAnalystRepository;
import za.ac.cput.Repository.Implementation.Police.DataAnalystRepositoryImplementation;

import java.util.Set;


public class DataAnalystRepositoryImplementationTest {

    private DataAnalystRepository dataAnalystRepository;
    private DataAnalyst dataAnalyst;

    public DataAnalyst getSavedDA() {
        Set<DataAnalyst> dataAnalystSet = this.dataAnalystRepository.getDataAnalystSet();
        return dataAnalystSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.dataAnalystRepository = DataAnalystRepositoryImplementation.getRepository();
        this.dataAnalyst = DataAnalystFactory.getDataAnalyst("90005","Jane","Watson");
    }

    @Test
    public void create(){
        DataAnalyst createdDA = this.dataAnalystRepository.create(this.dataAnalyst);
        System.out.println("Successfully created Data Analyst" + "\n" + dataAnalyst);
        Assert.assertSame(createdDA,this.dataAnalyst);
    }

    @Test
    public void update(){
        String name = "Jamie";
        DataAnalyst dataAnalyst =  new DataAnalyst.Builder().copy(getSavedDA()).daName(name).build();
        System.out.println("Updating" + "\n" + dataAnalyst );
        DataAnalyst updatedName = this.dataAnalystRepository.update(dataAnalyst);
        System.out.println("Updated" + "\n" + updatedName);
        Assert.assertSame(name,updatedName.getDaName());
    }

    @Test
    public void delete(){
        DataAnalyst dataAnalystSaved = getSavedDA();
        this.dataAnalystRepository.delete(dataAnalystSaved.getDaID());
    }

    @Test
    public void read(){
        DataAnalyst dataAnalystSaved = getSavedDA();
        System.out.println("Read Data Analyst id" + "\n" + dataAnalystSaved.getDaID());
        DataAnalyst read = this.dataAnalystRepository.read(dataAnalystSaved.getDaID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(dataAnalystSaved,read);
    }

    @Test
    public void getConvictSet(){
        Set<DataAnalyst> dataAnalystSet = this.dataAnalystRepository.getDataAnalystSet();
        System.out.println("List of Data Analysts" + "\n" + dataAnalystSet);
    }
}
