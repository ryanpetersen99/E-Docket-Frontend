package za.ac.cput.repository.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.factory.Police.InspectorFactory;
import za.ac.cput.repository.implementation.Police.InspectorRepositoryImplementation;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class InspectorRepositoryImplementationTest {


    private InspectorRepositoryImplementation inspectorRepository;
    private Inspector inspector;

    @Before
    public void setUp() throws Exception {

        inspectorRepository = InspectorRepositoryImplementation.getRepository();
        inspector = InspectorFactory.getInspector("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getAll() {
        inspectorRepository.create(inspector);
        assertNotNull(inspectorRepository.getInspectorSet());
        System.out.println("Get All\n" + inspectorRepository.getInspectorSet());
    }

    @Test
    public void InspectorCreateTest() throws IOException {
        inspectorRepository.create(inspector);
        Assert.assertNotNull(inspectorRepository.getInspectorSet());
        System.out.println("Created\n" + inspectorRepository.getInspectorSet());
    }

    @Test
    public void update() {

        inspectorRepository.create(inspector);

        Inspector updatedInspector = InspectorFactory.getInspector("37443", "Ryan", "Petersen", "5555");

        inspectorRepository.update(updatedInspector);

        Assert.assertNotEquals(inspector.getInspectorID(), updatedInspector.getInspectorID());
    }

    @Test
    public void delete() {
        inspectorRepository.delete("37443");
        assertNull(inspectorRepository.read("37443"));
        System.out.println("Deleted\n" + inspectorRepository.read("37443"));
    }

}