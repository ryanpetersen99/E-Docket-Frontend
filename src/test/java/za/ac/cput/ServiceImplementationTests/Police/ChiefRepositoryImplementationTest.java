package za.ac.cput.ServiceImplementationTests.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Chief;
import za.ac.cput.Factory.Police.ChiefFactory;
import za.ac.cput.Repository.Implementation.Police.ChiefRepositoryImplementation;
import za.ac.cput.Repository.Police.ChiefRepository;

import java.util.Set;

public class ChiefRepositoryImplementationTest {

    private ChiefRepository chiefRepository;
    private Chief chief;

    public Chief getSavedChief() {
        Set<Chief> chiefSet = this.chiefRepository.getChiefSet();
        return chiefSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.chiefRepository = ChiefRepositoryImplementation.getRepository();
        this.chief = ChiefFactory.getChief("90003","Andy","Herra","1000");
    }

    @Test
    public void create(){
        Chief createdChief = this.chiefRepository.create(this.chief);
        System.out.println("Successfully created chief" + "\n" + createdChief);
        Assert.assertSame(createdChief,this.chief);
    }

    @Test
    public void update(){
        String updatedID = "90002";
        Chief chief =  new Chief.Builder().copy(getSavedChief()).chiefID(updatedID).build();
        System.out.println("Updating" + "\n" + chief );
        Chief updatedChiefID = this.chiefRepository.update(chief);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(updatedID,updatedChiefID.getChiefID());
    }

    @Test
    public void delete(){
        Chief chiefSaved = getSavedChief();
        this.chiefRepository.delete(getSavedChief().getChiefID());
    }

    @Test
    public void read(){
        Chief chiefSaved = getSavedChief();
        System.out.println("Read chief id number" + "\n" + chiefSaved.getChiefID());
        Chief read = this.chiefRepository.read(chiefSaved.getChiefID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(chiefSaved,read);
    }

    @Test
    public void getConvictSet(){
        Set<Chief> chiefSet = this.chiefRepository.getChiefSet();
        System.out.println("Chief" + "\n" + chief);;
    }
}
