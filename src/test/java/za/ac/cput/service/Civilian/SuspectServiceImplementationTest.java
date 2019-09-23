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
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.factory.Civilian.SuspectFactory;
import za.ac.cput.service.Civilian.implementation.SuspectServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class SuspectServiceImplementationTest {

    SuspectServiceImplementation service;
    Suspect suspect;

    @Before
    public void setUp() throws Exception {
        service = SuspectServiceImplementation.getSuspectService();
        suspect = SuspectFactory.getSuspect("8888", "Ryan", "Petersen", "Mugged");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(suspect);
        assertNotNull(service.getSuspectSet());
        System.out.println("Get All\n" + service.getSuspectSet());
    }

    @Test
    public void create() {
        service.create(suspect);
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
        service.create(suspect);
        System.out.println(service.read("8888"));

        Suspect suspectUpdated = SuspectFactory.getSuspect("8888", "Ty", "Petersen", "Mugged");
        service.update(suspectUpdated);

        Suspect sus = service.read("8888");
        Assert.assertNotEquals(suspect.getSuspectName(), sus.getSuspectName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(suspect.getSuspectID()));
        System.out.println("Delete\n" + service.read(suspect.getSuspectID()));
    }

}