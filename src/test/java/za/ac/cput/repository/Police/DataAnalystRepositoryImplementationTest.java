package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.factory.Police.DataAnalystFactory;
import za.ac.cput.factory.Police.DataAnalystFactory;
import za.ac.cput.repository.implementation.Police.DataAnalystRepositoryImplementation;
import za.ac.cput.repository.implementation.Police.DataAnalystRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class DataAnalystRepositoryImplementationTest {


    private DataAnalystRepositoryImplementation daRepository;
    private DataAnalyst da;

    @Before
    public void setUp() throws Exception {

        daRepository = DataAnalystRepositoryImplementation.getRepository();
        da = DataAnalystFactory.getDataAnalyst("8888", "Ryan", "Petersen");
    }

    @Test
    public void getAll() {
        daRepository.create(da);
        assertNotNull(daRepository.getDataAnalystSet());
        System.out.println("Get All\n" + daRepository.getDataAnalystSet());
    }

    @Test
    public void DataAnalystCreateTest() throws IOException {
        daRepository.create(da);
        Assert.assertNotNull(daRepository.getDataAnalystSet());
        System.out.println("Created\n" + daRepository.getDataAnalystSet() );
    }

    @Test
    public void update() {

        daRepository.create(da);

        DataAnalyst updatedDataAnalyst = DataAnalystFactory.getDataAnalyst("37443", "Ryan", "Petersen");

        daRepository.update(updatedDataAnalyst);

        Assert.assertNotEquals(da.getDaID(), updatedDataAnalyst.getDaID());
    }

    @Test
    public void delete() {
        daRepository.delete("37443");
        assertNull(daRepository.read("37443"));
        System.out.println("Deleted\n" + daRepository.read("37443"));
    }
}