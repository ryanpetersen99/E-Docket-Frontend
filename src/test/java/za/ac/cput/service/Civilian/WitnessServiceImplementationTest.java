package za.ac.cput.service.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.factory.Civilian.WitnessFactory;
import za.ac.cput.repository.Civilian.WitnessRepository;
import za.ac.cput.repository.implementation.Civillian.WitnessRepositoryImplementation;

import java.util.Set;


public class WitnessServiceImplementationTest {

    private WitnessRepository witnessRepository;
    private Witness witness;
    private Witness witness2;


    public Witness getSavedWitness() {
        Set<Witness> witnessSet = this.witnessRepository.getWitnessSet();
        return witnessSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.witnessRepository = WitnessRepositoryImplementation.getRepository();
        this.witness = WitnessFactory.getWitness("9412125658364", "Ryan", "Petersen", "Witnessed a gentlemen getting assaulted");
        this.witness2 = WitnessFactory.getWitness("944525658364", "Reagen", "Peters", "Witnessed a gentlemen getting assaulted");

    }

    @Test
    public void create() {
        Witness createdWitness = this.witnessRepository.create(this.witness);
        Witness createdWitness2 = this.witnessRepository.create(this.witness2);
        System.out.println("Successfully created witness" + "\n" + createdWitness);
        System.out.println("Successfully created witness 2" + "\n" + createdWitness2);
        Assert.assertSame(createdWitness, this.witness);
        Assert.assertSame(createdWitness2, this.witness2);
    }

    @Test
    public void update() {
        String updatedSname = "Peterson";
        Witness witness = new Witness.Builder().copy(getSavedWitness()).witnessSurname(updatedSname).build();
        Witness updatedSurname = this.witnessRepository.update(witness);
        System.out.println("Updated" + "\n" + witness);
        Assert.assertSame(updatedSname, updatedSurname.getWitnessSurname());
    }

    @Test
    public void delete() {
        Witness witnessSaved = getSavedWitness();
        this.witnessRepository.delete(witnessSaved.getWitnessID());
        getWitnessSet();
    }

    @Test
    public void read() {
        Witness witnessSaved = getSavedWitness();
        Witness read = this.witnessRepository.read(witnessSaved.getWitnessID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(witnessSaved, read);
    }

    @Test
    public void getWitnessSet() {
        Set<Witness> witnesstSet = this.witnessRepository.getWitnessSet();
        System.out.println("List of witness" + "\n" + witnesstSet);
        Assert.assertEquals(1, witnesstSet.size());
    }
}
