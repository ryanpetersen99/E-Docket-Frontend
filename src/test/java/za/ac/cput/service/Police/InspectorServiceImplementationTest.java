package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.factory.Police.InspectorFactory;
import za.ac.cput.repository.Police.InspectorRepository;
import za.ac.cput.repository.implementation.Police.InspectorRepositoryImplementation;

import java.util.Set;


public class InspectorServiceImplementationTest {

    private InspectorRepository inspectorRepository;
    private Inspector inspector;
    private Inspector inspector2;

    public Inspector getSavedInspector() {
        Set<Inspector> inspectorSet = this.inspectorRepository.getInspectorSet();
        return inspectorSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.inspectorRepository = InspectorRepositoryImplementation.getRepository();
        this.inspector = InspectorFactory.getInspector("90005", "Jane", "Watson", "7001");
        this.inspector2 = InspectorFactory.getInspector("90888", "Killer", "Gumede", "7009");
    }

    @Test
    public void create() {
        Inspector createdI = this.inspectorRepository.create(this.inspector);
        Inspector created2 = this.inspectorRepository.create(this.inspector2);
        System.out.println("Successfully created Inspector" + "\n" + inspector);
        System.out.println("Successfully created Inspector 2" + "\n" + inspector2);
        Assert.assertSame(createdI, this.inspector);
        Assert.assertSame(created2, this.inspector2);
    }

    @Test
    public void update() {
        String id = "90009";
        Inspector inspector = new Inspector.Builder().copy(getSavedInspector()).inspectorID(id).build();
        this.inspectorRepository.update(inspector);
        System.out.println("Updated" + "\n" + inspector);
        Assert.assertSame(id, inspector.getInspectorID());
    }

    @Test
    public void delete() {
        Inspector inspectorSaved = getSavedInspector();
        this.inspectorRepository.delete(inspectorSaved.getInspectorID());
        getInspectorSet();
    }

    @Test
    public void read() {
        Inspector inspectorSaved = getSavedInspector();
        Inspector read = this.inspectorRepository.read(inspectorSaved.getInspectorID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(inspectorSaved, read);
    }

    @Test
    public void getInspectorSet() {
        Set<Inspector> inspectorSet = this.inspectorRepository.getInspectorSet();
        System.out.println("List of Inspectors" + "\n" + inspectorSet);
        Assert.assertEquals(1, inspectorSet.size());
    }
}
