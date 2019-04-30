package za.ac.cput.RepositoryImplementationTests.Civillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Civillian.Complainant;
import za.ac.cput.Factory.Civillian.ComplainantFactory;
import za.ac.cput.Repository.Civillian.ComplainantRepository;
import za.ac.cput.Repository.Implementation.Civillian.ComplainantRepositoryImplementation;

import java.util.Set;


public class ComplainantRepositoryImplementationTest {

    private ComplainantRepository complainantRepository;
    private Complainant complainant;// = ComplainantFactory.getComplainant("9906145468964","James","Milner","Got assaulted");
    private Complainant complainant2;


    public Complainant getSavedComplainant() {
        Set<Complainant> complainantSet = this.complainantRepository.getComplainantSet();
        return complainantSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
        this.complainant = ComplainantFactory.getComplainant("9906145468964","James","Milner","Got assaulted");
        this.complainant2 = ComplainantFactory.getComplainant("9906145460000","John","Smith","Got mugged");

    }

    @Test
    public void create(){
        Complainant createdComplainant = this.complainantRepository.create(this.complainant);
        System.out.println("Successfully created complainant" + "\n" + createdComplainant);
        Complainant createdComplainant2 = this.complainantRepository.create(this.complainant2);
        System.out.println("Successfully created complainant" + "\n" + createdComplainant2);
     //   getComplainantSet();
        Assert.assertSame(createdComplainant,this.complainant);
        Assert.assertSame(createdComplainant2,this.complainant2);
    }

    @Test
    public void update(){
        String updatedStatement = "Got assaulted and mugged";
        Complainant complainant =  new Complainant.Builder().copy(getSavedComplainant()).complainantStatement(updatedStatement).build();
        System.out.println("Updating" + "\n" + complainant );
        Complainant updatedCompID = this.complainantRepository.update(complainant);
        System.out.println("Updated" + "\n" + updatedCompID);
        Assert.assertSame(updatedStatement,updatedCompID.getComplainantStatement());
    }

    @Test
    public void delete(){
        Complainant complainantSaved = getSavedComplainant();
        this.complainantRepository.delete(complainantSaved.getComplainantID());
    }

    @Test
    public void read(){
        Complainant complainantSaved = getSavedComplainant();
        System.out.println("Read complainant id number" + "\n" + complainantSaved.getComplainantID());
        Complainant read = this.complainantRepository.read(complainantSaved.getComplainantID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(complainantSaved,read);
    }

    @Test
    public void getComplainantSet(){
        Set<Complainant> complainantSet = this.complainantRepository.getComplainantSet();
        System.out.println("List of complainants" + "\n" + complainantSet);
   //     Assert.assertEquals(1,complainantSet.size());
    }
}
