package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.Docket;
import za.ac.cput.factory.System.DocketFactory;
import za.ac.cput.repository.implementation.System.DocketRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class DocketRepositoryImplementationTest {


    private DocketRepositoryImplementation dokcetRepository;
    private Docket dokcet;

    @Before
    public void setUp() throws Exception {

        dokcetRepository = DocketRepositoryImplementation.getRepository();
        dokcet = DocketFactory.getDocket("8888");
    }

    @Test
    public void getAll() {
        dokcetRepository.create(dokcet);
        assertNotNull(dokcetRepository.getDocketSet());
        System.out.println("Get All\n" + dokcetRepository.getDocketSet());
    }

    @Test
    public void DocketCreateTest() throws IOException {
        dokcetRepository.create(dokcet);
        Assert.assertNotNull(dokcetRepository.getDocketSet());
        System.out.println("Created\n" + dokcetRepository.getDocketSet());
    }

    @Test
    public void update() {

        dokcetRepository.create(dokcet);

        Docket updatedDocket = DocketFactory.getDocket("37443");

        dokcetRepository.update(updatedDocket);

        Assert.assertNotEquals(dokcet.getDocketID(), updatedDocket.getDocketID());
    }

    @Test
    public void delete() {
        dokcetRepository.delete("37443");
        assertNull(dokcetRepository.read("37443"));
        System.out.println("Deleted\n" + dokcetRepository.read("37443"));
    }
}