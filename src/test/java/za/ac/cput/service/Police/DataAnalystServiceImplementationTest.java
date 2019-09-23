package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.factory.Police.DataAnalystFactory;
import za.ac.cput.service.Police.implementation.DataAnalystServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class DataAnalystServiceImplementationTest {

    DataAnalystServiceImplementation service;
    DataAnalyst da;

    @Before
    public void setUp() throws Exception {
        service = (DataAnalystServiceImplementation) DataAnalystServiceImplementation.getDaService();
        da = DataAnalystFactory.getDataAnalyst("8888", "Ryan","Petersen");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(da);
        assertNotNull(service.getDataAnalystSet());
        System.out.println("Get All\n" + service.getDataAnalystSet());
    }

    @Test
    public void create() {
        service.create(da);
        assertNotNull(service.read("8888"));
        System.out.println("Created\n" + service.read("8888"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("8888"));
        System.out.println("Read\n" + service.read("8888"));
    }

    @Test
    public void update() {
        service.create(da);
        System.out.println(service.read("8888"));

        DataAnalyst daUpdated = DataAnalystFactory.getDataAnalyst("5555", "Ryaaan","Petersen");
        service.update(daUpdated);

        DataAnalyst comp = service.read("8888");
        Assert.assertNotEquals(da.getDaName(), comp.getDaName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(da.getDaID()));
        System.out.println("Delete\n" + service.read(da.getDaID()));
    }

}