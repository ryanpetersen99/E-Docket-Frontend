package za.ac.cput.ServiceImplementationTests.Police;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Police.Inspector;
import za.ac.cput.Factory.Police.InpsectorFactory;
import za.ac.cput.Repository.Implementation.Police.InspectorRepositoryImplementation;
import za.ac.cput.Repository.Police.InspectorRepository;

import java.util.Set;


public class InspectorRepositoryImplementationTest {

    private InspectorRepository inspectorRepository;
    private Inspector inspector;

    public Inspector getSavedInspector() {
        Set<Inspector> inspectorSet = this.inspectorRepository.getInspectorSet();
        return inspectorSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.inspectorRepository = InspectorRepositoryImplementation.getRepository();
        this.inspector = InpsectorFactory.getInspector("90005","Jane","Watson","7001");
    }

    @Test
    public void create(){
        Inspector createdI = this.inspectorRepository.create(this.inspector);
        System.out.println("Successfully created Inspector" + "\n" + inspector);
        Assert.assertSame(createdI,this.inspector);
    }

    @Test
    public void update(){
        String id = "90009";
        Inspector inspector =  new Inspector.Builder().copy(getSavedInspector()).inspectorID(id).build();
        System.out.println("Updating" + "\n" + inspector );
        Inspector updatedID = this.inspectorRepository.update(inspector);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getInspectorID());
    }

    @Test
    public void delete(){
        Inspector inspectorSaved = getSavedInspector();
        this.inspectorRepository.delete(getSavedInspector().getInspectorID());
    }

    @Test
    public void read(){
        Inspector inspectorSaved = getSavedInspector();
        System.out.println("Read inspector id" + "\n" + inspectorSaved.getInspectorID());
        Inspector read = this.inspectorRepository.read(inspectorSaved.getInspectorID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(inspectorSaved,read);
    }

    @Test
    public void getInspectorSet(){
        Set<Inspector> inspectorSet = this.inspectorRepository.getInspectorSet();
        System.out.println("List of Inspectors" + "\n" + inspectorSet);
    }
}
