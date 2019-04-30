package za.ac.cput.RepositoryImplementationTests.Civillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Factory.Civillian.ConvictFactory;
import za.ac.cput.Repository.Civillian.ConvictRepository;
import za.ac.cput.Repository.Implementation.Civillian.ConvictRepositoryImplementation;

import java.util.Set;


public class ConvictRepositoryImplementationTest {

    private ConvictRepository convictRepository;
    private Convict convict;

    public Convict getSavedConvict() {
        Set<Convict> convicts = this.convictRepository.getConvictSet();
        return convicts.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.convictRepository = ConvictRepositoryImplementation.getRepository();
        this.convict = ConvictFactory.getConvict("9906145463245","Tim","Smith","Sentenced to 5 months in jail for assault");
    }

    @Test
    public void create(){
        Convict createdConvict = this.convictRepository.create(this.convict);
        System.out.println("Successfully created convict" + "\n" + createdConvict);
       // Complainant createdComplainant2 = this.complainantRepository.create(this.complainant2);
      //  System.out.println("Successfully created complainant" + "\n" + createdComplainant2);
        //   getComplainantSet();
        Assert.assertSame(createdConvict,this.convict);
     //   Assert.assertSame(createdComplainant2,this.complainant2);
    }

    @Test
    public void update(){
        String updatedConviction = "Sentenced to 12 months for assault";
        Convict convict =  new Convict.Builder().copy(getSavedConvict()).natureOfConviction(updatedConviction).build();
        System.out.println("Updating" + "\n" + convict );
        Convict updatedConID = this.convictRepository.update(convict);
        System.out.println("Updated" + "\n" + updatedConID);
        Assert.assertSame(updatedConviction,updatedConID.getNatureOfConviction());
    }

    @Test
    public void delete(){
        Convict convictSaved = getSavedConvict();
        this.convictRepository.delete(convictSaved.getConvictID());
    }

    @Test
    public void read(){
        Convict convictSaved = getSavedConvict();
        System.out.println("Read convict id number" + "\n" + convictSaved.getConvictID());
        Convict read = this.convictRepository.read(convictSaved.getConvictID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(convictSaved,read);
    }

    @Test
    public void getConvictSet(){
        Set<Convict> convict = this.convictRepository.getConvictSet();
        System.out.println("List of convicts" + "\n" + convict);
      //  Assert.assertEquals(1,convict.size());
    }
}
