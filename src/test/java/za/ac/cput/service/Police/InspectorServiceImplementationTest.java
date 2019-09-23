package za.ac.cput.service.Police;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.factory.Police.InspectorFactory;
import za.ac.cput.service.Police.implementation.InspectorServiceImplementation;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest(classes = EDocketSystem.class)
@RunWith(SpringRunner.class)
public class InspectorServiceImplementationTest {

    InspectorServiceImplementation service;
    Inspector inspector;

    @Before
    public void setUp() throws Exception {
        service = InspectorServiceImplementation.getInspectorService();
        inspector = InspectorFactory.getInspector("8888", "Ryan", "Petersen", "5555");
    }

    @Test
    public void getService() {
        assertNotNull(service);
        System.out.println(service);
    }

    @Test
    public void getAll() {
        service.create(inspector);
        assertNotNull(service.getInspectorSet());
        System.out.println("Get All\n" + service.getInspectorSet());
    }

    @Test
    public void create() {
        service.create(inspector);
        assertNotNull(service.read("8888"));
        System.out.println("Created\n" + service.read("8888"));
    }

    @Test
    public void read() {
        assertNotNull(service.read("8888"));
        System.out.println("Read\n" + service.read("8888"));
    }

    @Test
    public void update() {
        service.create(inspector);
        System.out.println(service.read("8888"));

        Inspector inspectorUpdated = InspectorFactory.getInspector("8888", "Ryaaan", "Petersen", "5555");
        service.update(inspectorUpdated);

        Inspector comp = service.read("8888");
        Assert.assertNotEquals(inspector.getInspectorName(), comp.getInspectorName());
        System.out.println("Updated\n" + service.read("8888"));
    }

    @Test
    public void delete() {
        service.delete("8888");
        assertNull(service.read(inspector.getInspectorID()));
        System.out.println("Delete\n" + service.read(inspector.getInspectorID()));
    }

}
