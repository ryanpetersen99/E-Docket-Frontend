package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Police.Administrator;
import za.ac.cput.factory.Police.AdministratorFactory;
import za.ac.cput.repository.Police.AdministratorRepository;
import za.ac.cput.repository.implementation.Police.AdministratorRepositoryImplementation;

import java.util.Set;


public class AdministratorServiceImplementationTest {

    private AdministratorRepository administratorRepository;
    private Administrator administrator;
    private Administrator administrator2;


    public Administrator getSavedAdmin() {
        Set<Administrator> administratorSet = this.administratorRepository.getAdministratorSet();
        return administratorSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.administratorRepository = AdministratorRepositoryImplementation.getRepository();
        this.administrator = AdministratorFactory.getAdministrator("90001", "Banks", "Kim");
        this.administrator2 = AdministratorFactory.getAdministrator("90002", "Lee", "Kim");

    }

    @Test
    public void create() {
        Administrator createdAdmin = this.administratorRepository.create(this.administrator);
        Administrator createdAdmin2 = this.administratorRepository.create(this.administrator2);
        System.out.println("Successfully created administrator" + "\n" + createdAdmin);
        System.out.println("Successfully created administrator 2" + "\n" + createdAdmin2);
        Assert.assertSame(createdAdmin, this.administrator);
        Assert.assertSame(createdAdmin2, this.administrator2);
    }

    @Test
    public void update() {
        String updatedID = "90003";
        Administrator administrator = new Administrator.Builder().copy(getSavedAdmin()).adminID(updatedID).build();
        this.administratorRepository.update(administrator);
        System.out.println("Updated" + "\n" + administrator);
        Assert.assertSame(updatedID, administrator.getAdminID());
    }

    @Test
    public void delete() {
        Administrator administratorSaved = getSavedAdmin();
        this.administratorRepository.delete(administratorSaved.getAdminID());
    }

    @Test
    public void read() {
        Administrator administratorSaved = getSavedAdmin();
        Administrator read = this.administratorRepository.read(administratorSaved.getAdminID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedAdmin(), read);
    }

    @Test
    public void getAdminSet() {
        Set<Administrator> administratorSet = this.administratorRepository.getAdministratorSet();
        System.out.println("List of Administrators" + "\n" + administratorSet);
        Assert.assertEquals(1, administratorSet.size());

    }
}
