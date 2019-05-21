package za.ac.cput.ServiceImplementationTest.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Factory.Police.OfficerFactory;
import za.ac.cput.Repository.Implementation.Police.OfficerRepositoryImplementation;
import za.ac.cput.Repository.Police.OfficerRepository;

import java.util.Set;

public class OfficerServiceImplementationTest {

    private OfficerRepository officerRepository;
    private Officer officer;
    private Officer officer2;

    public Officer getSavedOfficer() {
        Set<Officer> officerSet = this.officerRepository.getOfficerSet();
        return officerSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.officerRepository = OfficerRepositoryImplementation.getRepository();
        this.officer = OfficerFactory.getOfficer("90011","Nbolo","May","7004");
        this.officer2 = OfficerFactory.getOfficer("90012","Olo","June","7005");
    }

    @Test
    public void create(){
        Officer createdO = this.officerRepository.create(this.officer);
        Officer createdO2 = this.officerRepository.create(this.officer2);
        System.out.println("Successfully created officer" + "\n" + officer);
        System.out.println("Successfully created officer 2" + "\n" + officer2);
        Assert.assertSame(createdO,this.officer);
        Assert.assertSame(createdO2,this.officer2);
    }

    @Test
    public void update(){
        String id = "90012";
        Officer officer =  new Officer.Builder().copy(getSavedOfficer()).officerID(id).build();
        this.officerRepository.update(officer);
        System.out.println("Updated" + "\n" + officer);
        Assert.assertSame(id,officer.getOfficerID());
    }

    @Test
    public void delete(){
        Officer officerSaved = getSavedOfficer();
        this.officerRepository.delete(officerSaved.getOfficerID());
        getOfficerSet();
    }

    @Test
    public void read(){
        Officer officerSaved = getSavedOfficer();
        Officer read = this.officerRepository.read(officerSaved.getOfficerID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(officerSaved,read);
    }

    @Test
    public void getOfficerSet(){
        Set<Officer> officerSet = this.officerRepository.getOfficerSet();
        System.out.println("List of Officers" + "\n" + officerSet);
        Assert.assertEquals(1,officerSet.size());
    }
}
