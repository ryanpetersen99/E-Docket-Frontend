package za.ac.cput.ServiceImplementationTests.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Civilian.Witness;
import za.ac.cput.Factory.Civilian.WitnessFactory;
import za.ac.cput.Repository.Civilian.WitnessRepository;
import za.ac.cput.Repository.Implementation.Civillian.WitnessRepositoryImplementation;

import java.util.Set;


public class WitnessRepositoryServiceTest {

    private WitnessRepository witnessRepository;
    private Witness witness;


    public Witness getSavedWitness() {
        Set<Witness> witnessSet = this.witnessRepository.getWitnessSet();
        return witnessSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.witnessRepository = WitnessRepositoryImplementation.getRepository();
        this.witness = WitnessFactory.getWitness("9412125658364","Ryan","Petersen","Witnessed a gentlemen getting assaulted");
    }

    @Test
    public void create(){
        Witness createdWitness = this.witnessRepository.create(this.witness);
        System.out.println("Successfully created witness" + "\n" + createdWitness);
        Assert.assertSame(createdWitness,this.witness);
    }

    @Test
    public void update(){
        String updatedSname = "Peterson";
        Witness witness =  new Witness.Builder().copy(getSavedWitness()).witnessSurname(updatedSname).build();
        System.out.println("Updating" + "\n" + witness );
        Witness updatedSurname = this.witnessRepository.update(witness);
        System.out.println("Updated" + "\n" + updatedSname);
        Assert.assertSame(updatedSname,updatedSurname.getWitnessSurname());
    }

    @Test
    public void delete(){
        Witness witnessSaved = getSavedWitness();
        this.witnessRepository.delete(witnessSaved.getWitnessID());
    }

    @Test
    public void read(){
        Witness witnessSaved = getSavedWitness();
        System.out.println("Read witness id number" + "\n" + witnessSaved.getWitnessID());
        Witness read = this.witnessRepository.read(witnessSaved.getWitnessID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(witnessSaved,read);
    }

    @Test
    public void getComplainantSet(){
        Set<Witness> witnesstSet = this.witnessRepository.getWitnessSet();
        System.out.println("List of witness" + "\n" + witnesstSet);
        //     Assert.assertEquals(1,complainantSet.size());
    }
}
