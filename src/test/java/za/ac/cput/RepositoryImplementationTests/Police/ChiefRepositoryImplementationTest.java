package za.ac.cput.RepositoryImplementationTests.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Chief;
import za.ac.cput.Factory.Police.ChiefFactory;
import za.ac.cput.Repository.Police.ChiefRepository;
import za.ac.cput.Repository.Implementation.Police.ChiefRepositoryImplementation;

import java.util.Set;

public class ChiefRepositoryImplementationTest {

    private ChiefRepository chiefRepository;
    private Chief chief;
    private Chief chief2;

    public Chief getSavedChief() {
        Set<Chief> chiefSet = this.chiefRepository.getChiefSet();
        return chiefSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.chiefRepository = ChiefRepositoryImplementation.getRepository();
        this.chief = ChiefFactory.getChief("90003","Andy","Herra","1000");
        this.chief2 = ChiefFactory.getChief("90003","Handy","Andy","1000");
    }

    @Test
    public void create(){
        Chief createdChief = this.chiefRepository.create(this.chief);
        Chief createdChief2 = this.chiefRepository.create(this.chief2);
        System.out.println("Successfully created chief" + "\n" + createdChief);
        System.out.println("Successfully created chief 2" + "\n" + createdChief2);
        Assert.assertSame(createdChief,this.chief);
        Assert.assertSame(createdChief2,this.chief2);
    }

    @Test
    public void update(){
        String updatedID = "90002";
        Chief chief =  new Chief.Builder().copy(getSavedChief()).chiefID(updatedID).build();
        Chief updatedChiefID = this.chiefRepository.update(chief);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(updatedID,updatedChiefID.getChiefID());
    }

    @Test
    public void delete(){
        Chief chiefSaved = getSavedChief();
        this.chiefRepository.delete(getSavedChief().getChiefID());
        getChiefSet();

    }

    @Test
    public void read(){
        Chief chiefSaved = getSavedChief();
        Chief read = this.chiefRepository.read(chiefSaved.getChiefID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(chiefSaved,read);
    }

    @Test
    public void getChiefSet(){
        Set<Chief> chiefSet = this.chiefRepository.getChiefSet();
        System.out.println("Chief" + "\n" + chiefSet);
        Assert.assertEquals(1,chiefSet.size());
    }
}
