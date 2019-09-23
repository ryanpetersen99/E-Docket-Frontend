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
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.factory.Police.AdministratorFactory;
import za.ac.cput.service.Police.implementation.AdministratorServiceImplementation;

import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class AdministratorServiceImplementationTest {

    AdministratorServiceImplementation service;
    Administrator admin;

    @Before
    public void setUp() throws Exception {
        service = (AdministratorServiceImplementation) AdministratorServiceImplementation.getAdminService();
        admin = AdministratorFactory.getAdministrator("8888", "Ryan","Petersen");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(admin);
        assertNotNull(service.getAdministratorSet());
        System.out.println("Get All\n" + service.getAdministratorSet());
    }

    @Test
    public void create() {
        service.create(admin);
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
        service.create(admin);
        System.out.println(service.read("8888"));

        Administrator adminUpdated = AdministratorFactory.getAdministrator("8888", "Ryaan","Petersen");
        service.update(adminUpdated);

        Administrator adm = service.read("8888");
        Assert.assertNotEquals(admin.getAdminName(), adm.getAdminName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(admin.getAdminID()));
        System.out.println("Delete\n" + service.read(admin.getAdminID()));
    }

}