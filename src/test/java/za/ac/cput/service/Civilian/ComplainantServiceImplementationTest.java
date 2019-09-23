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
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.factory.Civilian.ComplainantFactory;
import za.ac.cput.repository.Civilian.ComplainantRepository;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;
import za.ac.cput.service.Civilian.implementation.ComplainantServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class ComplainantServiceImplementationTest {

    ComplainantServiceImplementation service;
    Complainant complainant;

    @Before
    public void setUp() throws Exception {
        service = ComplainantServiceImplementation.getCompService();
        complainant = ComplainantFactory.getComplainant("8888", "Ryan","Petersen","Mugged");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(complainant);
        assertNotNull(service.getAll());
        System.out.println("Get All\n" + service.getAll());
    }

    @Test
    public void create() {
        service.create(complainant);
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
        service.create(complainant);
        System.out.println(service.read("8888"));

        Complainant complainantUpdated = ComplainantFactory.getComplainant("8888", "Ryann","Petersenn","Muggged");
        service.update(complainantUpdated);

        Complainant comp = service.read("8888");
        Assert.assertNotEquals(complainant.getComplainantName(), comp.getComplainantName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(complainant.getComplainantID()));
        System.out.println("Delete\n" + service.read(complainant.getComplainantID()));
    }

}