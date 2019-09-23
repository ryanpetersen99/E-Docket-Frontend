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
import za.ac.cput.domain.Police.Officer;
import za.ac.cput.factory.Police.OfficerFactory;
import za.ac.cput.service.Police.implementation.OfficerServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class OfficerServiceImplementationTest {

    OfficerServiceImplementation service;
    Officer officer;

    @Before
    public void setUp() throws Exception {
        service = OfficerServiceImplementation.getOfficerService();
        officer = OfficerFactory.getOfficer("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(officer);
        assertNotNull(service.getOfficerSet());
        System.out.println("Get All\n" + service.getOfficerSet());
    }

    @Test
    public void create() {
        service.create(officer);
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
        service.create(officer);
        System.out.println(service.read("8888"));

        Officer officerUpdated = OfficerFactory.getOfficer("5555", "Ryan", "Petersen", "5555");
        service.update(officerUpdated);

        Officer comp = service.read("8888");
        Assert.assertNotEquals(officer.getOfficerID(), comp.getOfficerID());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(officer.getOfficerID()));
        System.out.println("Delete\n" + service.read(officer.getOfficerID()));
    }

}