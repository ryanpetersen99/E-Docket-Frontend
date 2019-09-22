package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.factory.Police.DataAnalystFactory;
import za.ac.cput.repository.Police.DataAnalystRepository;
import za.ac.cput.repository.implementation.Police.DataAnalystRepositoryImplementation;

import java.util.Set;


public class DataAnalystServiceImplementationTest {

    private DataAnalystRepository dataAnalystRepository;
    private DataAnalyst dataAnalyst;
    private DataAnalyst dataAnalyst2;


    public DataAnalyst getSavedDA() {
        Set<DataAnalyst> dataAnalystSet = this.dataAnalystRepository.getDataAnalystSet();
        return dataAnalystSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.dataAnalystRepository = DataAnalystRepositoryImplementation.getRepository();
        this.dataAnalyst = DataAnalystFactory.getDataAnalyst("90005", "Jane", "Watson");
        this.dataAnalyst2 = DataAnalystFactory.getDataAnalyst("90002", "Manny", "Wanny");
    }

    @Test
    public void create() {
        DataAnalyst createdDA = this.dataAnalystRepository.create(this.dataAnalyst);
        DataAnalyst createdDA2 = this.dataAnalystRepository.create(this.dataAnalyst2);
        System.out.println("Successfully created Data Analyst" + "\n" + createdDA);
        System.out.println("Successfully created Data Analyst 2" + "\n" + createdDA2);
        Assert.assertSame(createdDA, this.dataAnalyst);
        Assert.assertSame(createdDA2, this.dataAnalyst2);
    }

    @Test
    public void update() {
        String name = "Jamie";
        DataAnalyst dataAnalyst = new DataAnalyst.Builder().copy(getSavedDA()).daName(name).build();
        DataAnalyst updatedName = this.dataAnalystRepository.update(dataAnalyst);
        System.out.println("Updated" + "\n" + updatedName);
        Assert.assertSame(name, updatedName.getDaName());
    }

    @Test
    public void delete() {
        DataAnalyst dataAnalystSaved = getSavedDA();
        this.dataAnalystRepository.delete(dataAnalystSaved.getDaID());
        getDASet();
    }

    @Test
    public void read() {
        DataAnalyst dataAnalystSaved = getSavedDA();
        DataAnalyst read = this.dataAnalystRepository.read(dataAnalystSaved.getDaID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(dataAnalystSaved, read);
    }

    @Test
    public void getDASet() {
        Set<DataAnalyst> dataAnalystSet = this.dataAnalystRepository.getDataAnalystSet();
        System.out.println("List of Data Analysts" + "\n" + dataAnalystSet);
    }
}
