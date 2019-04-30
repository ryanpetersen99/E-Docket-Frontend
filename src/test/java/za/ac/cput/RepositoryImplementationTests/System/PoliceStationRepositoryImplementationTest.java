package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Factory.System.PoliceStationFactory;
import za.ac.cput.Repository.Implementation.System.PendingCaseRepositoryImplementation;
import za.ac.cput.Repository.Implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.Repository.System.PoliceStationRepository;

import java.util.Set;


public class PoliceStationRepositoryImplementationTest {

    private PoliceStationRepository policeStationRepository;
    private PoliceStation policeStation;

    public PoliceStation getSavedStation() {
        Set<PoliceStation> policeStationSet = this.policeStationRepository.getPoliceStationSet();
        return policeStationSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.policeStationRepository = PoliceStationRepositoryImplementation.getRepository();
        this.policeStation = PoliceStationFactory.getPoliceStation("Mitchells Plain Station");
    }
    @Test
    public void create(){
        PoliceStation createdI = this.policeStationRepository.create(this.policeStation);
        System.out.println("Successfully created Police Station" + "\n" + policeStationRepository);
        Assert.assertSame(createdI,this.policeStation);
    }

    @Test
    public void update(){
        String name = "Woodstock Station";
        PoliceStation policeStation =  new PoliceStation.Builder().copy(getSavedStation()).stationName(name).build();
        System.out.println("Updating" + "\n" + policeStation );
        PoliceStation updatedName = this.policeStationRepository.update(policeStation);
        System.out.println("Updated" + "\n" + updatedName);
        Assert.assertSame(name,updatedName.getStationName());
    }

    @Test
    public void delete(){
        PoliceStation policeStation = getSavedStation();
        this.policeStationRepository.delete(getSavedStation().getStationName());
    }

    @Test
    public void read(){
        PoliceStation policeStation = getSavedStation();
        System.out.println("Read station name" + "\n" + getSavedStation().getStationName());
        PoliceStation read = this.policeStationRepository.read(getSavedStation().getStationName());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedStation(),read);
    }

    @Test
    public void getEvidenceSet(){
        Set<PoliceStation> policeStationSet = this.policeStationRepository.getPoliceStationSet();
        System.out.println("List of Police Stations" + "\n" + policeStationSet);
    }
}
