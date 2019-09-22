package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.factory.Civilian.SuspectFactory;
import za.ac.cput.repository.implementation.Civillian.SuspectRepositoryImplementation;

import java.util.Set;


public class SuspectRepositoryImplementationTest {

    private SuspectRepository suspectRepository;
    private Suspect suspect;
    private Suspect suspect2;

    public Suspect getSavedSuspect() {
        Set<Suspect> complainantSet = this.suspectRepository.getSuspectSet();
        return complainantSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.suspectRepository = SuspectRepositoryImplementation.getRepository();
        this.suspect = SuspectFactory.getSuspect("9906142935678", "Tonny", "Gunner", "Accused of committing forgery");
        this.suspect2 = SuspectFactory.getSuspect("9009092935678", "Lary", "Gunner", "Accused of committing forgery");

    }

    @Test
    public void create() {
        Suspect createdSuspect = this.suspectRepository.create(this.suspect);
        Suspect createdSuspect2 = this.suspectRepository.create(this.suspect2);
        System.out.println("Successfully created suspect" + "\n" + createdSuspect);
        Assert.assertSame(createdSuspect, this.suspect);
        Assert.assertSame(createdSuspect2, this.suspect2);
    }

    @Test
    public void update() {
        String updatedName = "Tony";
        Suspect suspect = new Suspect.Builder().copy(getSavedSuspect()).suspectName(updatedName).build();
        Suspect updatedNam = this.suspectRepository.update(suspect);
        System.out.println("Updated" + "\n" + suspect);
        Assert.assertSame(updatedName, updatedNam.getSuspectName());
    }

    @Test
    public void delete() {
        Suspect suspectSaved = getSavedSuspect();
        this.suspectRepository.delete(suspectSaved.getSuspectID());
        getSuspectSet();
    }

    @Test
    public void read() {
        Suspect suspectSaved = getSavedSuspect();
        Suspect read = this.suspectRepository.read(suspectSaved.getSuspectID());
        System.out.println("Read" + "\n" + read);
        Assert.assertSame(suspectSaved, read);
    }

    @Test
    public void getSuspectSet() {
        Set<Suspect> suspectSet = this.suspectRepository.getSuspectSet();
        System.out.println("Suspect List" + "\n" + suspectSet);
        Assert.assertEquals(1, suspectSet.size());
    }
}
