package za.ac.cput.ServiceImplementationTests.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Civilian.Suspect;
import za.ac.cput.Factory.Civilian.SuspectFactory;
import za.ac.cput.Repository.Civilian.SuspectRepository;
import za.ac.cput.Repository.Implementation.Civillian.SuspectRepositoryImplementation;

import java.util.Set;


public class SuspectServiceImplementationTest {

    private SuspectRepository suspectRepository;
    private Suspect suspect;

    public Suspect getSavedSuspect() {
        Set<Suspect> complainantSet = this.suspectRepository.getSuspectSet();
        return complainantSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.suspectRepository = SuspectRepositoryImplementation.getRepository();
        this.suspect = SuspectFactory.getSuspect("9906142935678","Tonny","Gunner","Accused of committing forgery");
    }

    @Test
    public void create(){
        Suspect createdSuspect = this.suspectRepository.create(this.suspect);
        System.out.println("Successfully created suspect" + "\n" + createdSuspect);
        //   getComplainantSet();
        Assert.assertSame(createdSuspect,this.suspect);
    }

    @Test
    public void update(){
        String updatedName = "Tony";
        Suspect suspect =  new Suspect.Builder().copy(getSavedSuspect()).suspectName(updatedName).build();
        System.out.println("Updating" + "\n" + suspect );
        Suspect updatedNam = this.suspectRepository.update(suspect);
        System.out.println("Updated" + "\n" + suspect);
        Assert.assertSame(updatedName,updatedNam.getSuspectName());
    }

    @Test
    public void delete(){
        Suspect suspectSaved = getSavedSuspect();
        this.suspectRepository.delete(suspectSaved.getSuspectID());
    }

    @Test
    public void read(){
        Suspect suspectSaved = getSavedSuspect();
        System.out.println("Read suspect id number" + "\n" + suspectSaved.getSuspectID());
        Suspect read = this.suspectRepository.read(suspectSaved.getSuspectID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(suspectSaved,read);

    }

    @Test
    public void getSuspectSet(){
        Set<Suspect> suspectSet = this.suspectRepository.getSuspectSet();
        System.out.println("Suspect List" + "\n"+ suspectSet);
    }
}
