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
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.factory.Civilian.VictimFactory;
import za.ac.cput.factory.Civilian.VictimFactory;
import za.ac.cput.repository.Civilian.VictimRepository;
import za.ac.cput.repository.implementation.Civillian.VictimRepositoryImplementation;
import za.ac.cput.service.Civilian.implementation.VictimServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class VictimServiceImplementationTest {

    VictimServiceImplementation service;
    Victim vicitm;

    @Before
    public void setUp() throws Exception {
        service = VictimServiceImplementation.getRepository();
        vicitm = VictimFactory.getVictim("8888", "Ryan","Petersen","Mugged");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(vicitm);
        assertNotNull(service.getVictimSet());
        System.out.println("Get All\n" + service.getVictimSet());
    }

    @Test
    public void create() {
        service.create(vicitm);
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
        service.create(vicitm);
        System.out.println(service.read("8888"));

        Victim vicitmUpdated = VictimFactory.getVictim("8888", "Ryaan","Petersen","Mugged");
        service.update(vicitmUpdated);

        Victim vic = service.read("8888");
        Assert.assertNotEquals(vicitm.getVictimName(), vic.getVictimName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(vicitm.getVictimID()));
        System.out.println("Delete\n" + service.read(vicitm.getVictimID()));
    }

}