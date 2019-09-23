package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.EDocketSystem;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.repository.implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.repository.implementation.System.PoliceStationRepositoryImplementation;

import java.io.IOException;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EDocketSystem.class)
public class PoliceStationRepositoryImplementationTest {


    private PoliceStationRepositoryImplementation policeStationRepository;
    private PoliceStation policeStation;

    @Before
    public void setUp() throws Exception {

        policeStationRepository = PoliceStationRepositoryImplementation.getRepository();
        policeStation = PoliceStationFactory.getPoliceStation("Manenburg");
    }

    @Test
    public void getAll() {
        policeStationRepository.create(policeStation);
        assertNotNull(policeStationRepository.getPoliceStationSet());
        System.out.println("Get All\n" + policeStationRepository.getPoliceStationSet());
    }

    @Test
    public void PoliceStationCreateTest() throws IOException {
        policeStationRepository.create(policeStation);
        Assert.assertNotNull(policeStationRepository.getPoliceStationSet());
        System.out.println("Created\n" + policeStationRepository.getPoliceStationSet());
    }

    @Test
    public void update() {

        policeStationRepository.create(policeStation);

        PoliceStation updatedPoliceStation = PoliceStationFactory.getPoliceStation("Woodstock");

        policeStationRepository.update(updatedPoliceStation);

        Assert.assertNotEquals(policeStation.getStationName(), updatedPoliceStation.getStationName());
    }

    @Test
    public void delete() {
        policeStationRepository.delete("37443");
        assertNull(policeStationRepository.read("37443"));
        System.out.println("Deleted\n" + policeStationRepository.read("37443"));
    }
}