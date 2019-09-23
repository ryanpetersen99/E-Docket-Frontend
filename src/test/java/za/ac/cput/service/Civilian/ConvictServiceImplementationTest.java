package za.ac.cput.service.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.factory.Civilian.ConvictFactory;
import za.ac.cput.service.Civilian.implementation.ConvictServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class ConvictServiceImplementationTest {

    ConvictServiceImplementation service;
    Convict convict;

    @Before
    public void setUp() throws Exception {
        service = ConvictServiceImplementation.getRepository();
        convict = ConvictFactory.getConvict("8888", "Ryan", "Petersen", "Mugged");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(convict);
        assertNotNull(service.getConvictSet());
        System.out.println("Get All\n" + service.getConvictSet());
    }

    @Test
    public void create() {
        service.create(convict);
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
        service.create(convict);
        System.out.println(service.read("8888"));

        Convict convictUpdated = ConvictFactory.getConvict("8888", "Ty", "Petersen", "Mugged");
        service.update(convictUpdated);

        Convict con = service.read("8888");
        Assert.assertNotEquals(convict.getConvictName(), con.getConvictName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(convict.getConvictID()));
        System.out.println("Delete\n" + service.read(convict.getConvictID()));
    }

}