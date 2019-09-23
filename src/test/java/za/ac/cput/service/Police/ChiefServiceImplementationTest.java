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
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.factory.Police.ChiefFactory;
import za.ac.cput.factory.Police.ChiefFactory;
import za.ac.cput.repository.Police.ChiefRepository;
import za.ac.cput.repository.implementation.Police.ChiefRepositoryImplementation;
import za.ac.cput.service.Police.implementation.ChiefServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class ChiefServiceImplementationTest {

    ChiefServiceImplementation service;
    Chief chief;

    @Before
    public void setUp() throws Exception {
        service = (ChiefServiceImplementation) ChiefServiceImplementation.getChiefService();
        chief = ChiefFactory.getChief("8888", "Ryan","Petersen","6666");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(chief);
        assertNotNull(service.getChiefSet());
        System.out.println("Get All\n" + service.getChiefSet());
    }

    @Test
    public void create() {
        service.create(chief);
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
        service.create(chief);
        System.out.println(service.read("8888"));

        Chief chiefUpdated = ChiefFactory.getChief("5555", "Ryan","Petersen","5555");
        service.update(chiefUpdated);

        Chief comp = service.read("8888");
        Assert.assertNotEquals(chief.getChiefID(), comp.getChiefID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(chief.getChiefID()));
        System.out.println("Delete\n" + service.read(chief.getChiefID()));
    }

}