package za.ac.cput.service.Civilian;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.factory.Civilian.ComplainantFactory;
import za.ac.cput.repository.Civilian.ComplainantRepository;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;

import java.util.Set;


public class ComplainantServiceImplementationTest {

    private ComplainantRepository complainantRepository;
    private Complainant complainant;
    private Complainant complainant2;


    public Complainant getSavedComplainant() {
        Set<Complainant> complainantSet = this.complainantRepository.getComplainantSet();
        return complainantSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.complainantRepository = ComplainantRepositoryImplementation.getRepository();
        this.complainant = ComplainantFactory.getComplainant("9906145468964", "James", "Milner", "Got assaulted");
        this.complainant2 = ComplainantFactory.getComplainant("9906145460000", "John", "Smith", "Got mugged");

    }

    @Test
    public void create() {
        Complainant createdComplainant = this.complainantRepository.create(this.complainant);
        System.out.println("Successfully created complainant" + "\n" + createdComplainant);
        Complainant createdComplainant2 = this.complainantRepository.create(this.complainant2);
        System.out.println("Successfully created complainant2" + "\n" + createdComplainant2);
        Assert.assertSame(createdComplainant, this.complainant);
        Assert.assertSame(createdComplainant2, this.complainant2);
    }

    @Test
    public void update() {
        String updatedStatement = "Got assaulted and mugged";
        Complainant complainant = new Complainant.Builder().copy(getSavedComplainant()).complainantStatement(updatedStatement).build();
        Complainant updatedCompID = this.complainantRepository.update(complainant);
        System.out.println("Updated" + "\n" + updatedCompID);
        Assert.assertSame(updatedStatement, updatedCompID.getComplainantStatement());
    }

    @Test
    public void delete() {
        Complainant complainantSaved = getSavedComplainant();
        this.complainantRepository.delete(complainantSaved.getComplainantID());
        getSavedComplainant();
    }

    @Test
    public void read() {
        Complainant complainantSaved = getSavedComplainant();
        Complainant read = this.complainantRepository.read(complainantSaved.getComplainantID());
        System.out.println("Read" + "\n" + read);
        Assert.assertSame(complainantSaved, read);
    }

    @Test
    public void getComplainantSet() {
        Set<Complainant> complainantSet = this.complainantRepository.getComplainantSet();
        System.out.println("List of complainants" + "\n" + complainantSet);
        Assert.assertEquals(1, complainantSet.size());
    }
}
