package za.ac.cput.ServiceImplementationTests.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Factory.Police.OfficerFactory;
import za.ac.cput.Repository.Implementation.Police.OfficerRepositoryImplementation;
import za.ac.cput.Repository.Police.OfficerRepository;

import java.util.Set;

public class OfficerRepositoryImplementationTest {

    private OfficerRepository officerRepository;
    private Officer officer;

    public Officer getSavedOfficer() {
        Set<Officer> officerSet = this.officerRepository.getOfficerSet();
        return officerSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.officerRepository = OfficerRepositoryImplementation.getRepository();
        this.officer = OfficerFactory.getOfficer("90011","Nbolo","May","7004");
    }

    @Test
    public void create(){
        Officer createdO = this.officerRepository.create(this.officer);
        System.out.println("Successfully created officer" + "\n" + officer);
        Assert.assertSame(createdO,this.officer);
    }

    @Test
    public void update(){
        String id = "90012";
        Officer officer =  new Officer.Builder().copy(getSavedOfficer()).officerID(id).build();
        System.out.println("Updating" + "\n" + officer );
        Officer updatedID = this.officerRepository.update(officer);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getOfficerID());
    }

    @Test
    public void delete(){
        Officer officerSaved = getSavedOfficer();
        this.officerRepository.delete(getSavedOfficer().getOfficerID());
    }

    @Test
    public void read(){
        Officer officerSaved = getSavedOfficer();
        System.out.println("Read officer id" + "\n" + officerSaved.getOfficerID());
        Officer read = this.officerRepository.read(officerSaved.getOfficerID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(officerSaved,read);
    }

    @Test
    public void getOfficerSet(){
        Set<Officer> officerSet = this.officerRepository.getOfficerSet();
        System.out.println("List of Officers" + "\n" + officerSet);
    }
}
