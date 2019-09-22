package za.ac.cput.repository.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.factory.Civilian.ConvictFactory;
import za.ac.cput.repository.implementation.Civillian.ConvictRepositoryImplementation;

import java.util.Set;


public class ConvictRepositoryImplementationTest {

    private ConvictRepository convictRepository;
    private Convict convict;
    private Convict convict2;

    public Convict getSavedConvict() {
        Set<Convict> convicts = this.convictRepository.getConvictSet();
        return convicts.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.convictRepository = ConvictRepositoryImplementation.getRepository();
        this.convict = ConvictFactory.getConvict("9906145463245", "Tim", "Smith", "Sentenced to 5 months in jail for assault");
        this.convict2 = ConvictFactory.getConvict("9206155463245", "Johnny", "Smith", "Sentenced to 5 months in jail for assault");

    }

    @Test
    public void create() {
        Convict createdConvict = this.convictRepository.create(this.convict);
        System.out.println("Successfully created convict" + "\n" + createdConvict);
        Convict createdConvict2 = this.convictRepository.create(this.convict2);
        System.out.println("Successfully created convict" + "\n" + createdConvict2);
        Assert.assertSame(createdConvict, this.convict);
    }

    @Test
    public void update() {
        String updatedConviction = "Sentenced to 12 months for assault";
        Convict convict = new Convict.Builder().copy(getSavedConvict()).natureOfConviction(updatedConviction).build();
        Convict updatedConID = this.convictRepository.update(convict);
        System.out.println("Updated" + "\n" + updatedConID);
        Assert.assertSame(updatedConviction, updatedConID.getNatureOfConviction());
    }

    @Test
    public void delete() {
        Convict convictSaved = getSavedConvict();
        this.convictRepository.delete(convictSaved.getConvictID());

    }

    @Test
    public void read() {
        Convict convictSaved = getSavedConvict();
        Convict read = this.convictRepository.read(convictSaved.getConvictID());
        System.out.println("Read" + "\n" + read);
        Assert.assertSame(convictSaved, read);
    }

    @Test
    public void getConvictSet() {
        Set<Convict> convict = this.convictRepository.getConvictSet();
        System.out.println("List of convicts" + "\n" + convict);
        Assert.assertEquals(1, convict.size());
    }
}
