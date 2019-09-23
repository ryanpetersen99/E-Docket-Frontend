package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.factory.Police.AdministratorFactory;
import za.ac.cput.repository.implementation.Police.AdministratorRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class AdministratorRepositoryImplementationTest {


    private AdministratorRepositoryImplementation adminRepository;
    private Administrator admin;

    @Before
    public void setUp() throws Exception {

        adminRepository = AdministratorRepositoryImplementation.getRepository();
        admin = AdministratorFactory.getAdministrator("8888", "Ryan", "Petersen");
    }

    @Test
    public void getAll() {
        adminRepository.create(admin);
        assertNotNull(adminRepository.getAdministratorSet());
        System.out.println("Get All\n" + adminRepository.getAdministratorSet());
    }

    @Test
    public void AdministratorCreateTest() throws IOException {
        adminRepository.create(admin);
        Assert.assertNotNull(adminRepository.getAdministratorSet());
        System.out.println("Created\n" + adminRepository.getAdministratorSet());
    }

    @Test
    public void update() {

        adminRepository.create(admin);

        Administrator updatedAdministrator = AdministratorFactory.getAdministrator("37443", "Ryan", "Petersen");

        adminRepository.update(updatedAdministrator);

        Assert.assertNotEquals(admin.getAdminID(), updatedAdministrator.getAdminID());
    }

    @Test
    public void delete() {
        adminRepository.delete("37443");
        assertNull(adminRepository.read("37443"));
        System.out.println("Deleted\n" + adminRepository.read("37443"));
    }

}