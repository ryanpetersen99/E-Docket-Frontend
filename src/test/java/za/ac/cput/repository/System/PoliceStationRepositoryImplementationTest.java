package za.ac.cput.repository.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.System.PoliceStation;
import za.ac.cput.factory.System.PoliceStationFactory;
import za.ac.cput.repository.implementation.System.PoliceStationRepositoryImplementation;

import java.util.Set;


public class PoliceStationRepositoryImplementationTest {

    private PoliceStationRepository policeStationRepository;
    private PoliceStation policeStation;
    private PoliceStation policeStation2;

    public PoliceStation getSavedStation() {
        Set<PoliceStation> policeStationSet = this.policeStationRepository.getPoliceStationSet();
        return policeStationSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.policeStationRepository = PoliceStationRepositoryImplementation.getRepository();
        this.policeStation = PoliceStationFactory.getPoliceStation("Mitchells Plain Station");
        this.policeStation2 = PoliceStationFactory.getPoliceStation("Manenberg Station");
    }

    @Test
    public void create() {
        PoliceStation createdI = this.policeStationRepository.create(this.policeStation);
        PoliceStation createdI2 = this.policeStationRepository.create(this.policeStation2);
        System.out.println("Successfully created Police Station" + "\n" + policeStation);
        System.out.println("Successfully created Police Station 2" + "\n" + policeStation2);
        Assert.assertSame(createdI, this.policeStation);
        Assert.assertSame(createdI2, this.policeStation2);
    }

    @Test
    public void update() {
        String name = "Woodstock Station";
        PoliceStation policeStation = new PoliceStation.Builder().copy(getSavedStation()).stationName(name).build();
        this.policeStationRepository.update(policeStation);
        System.out.println("Updated" + "\n" + policeStation);
        Assert.assertSame(name, policeStation.getStationName());
    }

    @Test
    public void delete() {
        PoliceStation policeStation = getSavedStation();
        this.policeStationRepository.delete(policeStation.getStationName());
        getStationSet();
    }

    @Test
    public void read() {
        PoliceStation policeStation = getSavedStation();
        PoliceStation read = this.policeStationRepository.read(policeStation.getStationName());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedStation(), read);
    }

    @Test
    public void getStationSet() {
        Set<PoliceStation> policeStationSet = this.policeStationRepository.getPoliceStationSet();
        System.out.println("List of Police Stations" + "\n" + policeStationSet);
        Assert.assertEquals(1, policeStationSet.size());
    }
}
