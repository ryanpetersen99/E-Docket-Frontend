package za.ac.cput.RepositoryImplementationTests.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Administrator;
import za.ac.cput.Factory.Police.AdministratorFactory;
import za.ac.cput.Repository.Police.AdministratorRepository;
import za.ac.cput.Repository.Implementation.Police.AdministratorRepositoryImplementation;

import java.util.Set;


public class AdministratorRepositoryImplementationTest {

    private AdministratorRepository administratorRepository;
    private Administrator administrator;


    public Administrator getSavedAdmin() {
        Set<Administrator> administratorSet = this.administratorRepository.getAdministratorSet();
        return administratorSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.administratorRepository = AdministratorRepositoryImplementation.getRepository();
        this.administrator = AdministratorFactory.getAdministrator("90001","Banks","Kim");

    }

    @Test
    public void create(){
        Administrator createdAdmin = this.administratorRepository.create(this.administrator);
        System.out.println("Successfully created administrator" + "\n" + createdAdmin);
        Assert.assertSame(createdAdmin,this.administrator);
    }

    @Test
    public void update(){
        String updatedID = "90002";
        Administrator administrator =  new Administrator.Builder().copy(getSavedAdmin()).adminID(updatedID).build();
        System.out.println("Updating" + "\n" + administrator );
        Administrator updatedAdmin = this.administratorRepository.update(administrator);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(updatedID,updatedAdmin.getAdminID());
    }
/*
    @Test
    public void delete(){
        Administrator administratorSaved = getSavedAdmin();
        this.administratorRepository.delete(getSavedAdmin().getAdminID());
    }

    @Test
    public void read(){
        Administrator administratorSaved = getSavedAdmin();
        System.out.println("Read admin id number" + "\n" + getSavedAdmin().getAdminID());
        Administrator read = this.administratorRepository.read(getSavedAdmin().getAdminID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedAdmin(),read);
    }

    @Test
    public void getAdminSet(){
        Set<Administrator> administratorSet = this.administratorRepository.getAdministratorSet();
        System.out.println("List of Administrators" + "\n" + administratorSet);
        //     Assert.assertEquals(1,complainantSet.size());
        */

}
