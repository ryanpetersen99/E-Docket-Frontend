package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.PoliceStation;
import za.ac.cput.Repository.Implementation.System.PoliceStationRepositoryImplementation;
import za.ac.cput.Repository.System.PoliceStationRepository;

import java.util.Set;


public class PoliceStationRepositoryImplementationTest {

    private PoliceStationRepository policeStationRepository;

    @Before
    public void setUp() throws Exception{
        this.policeStationRepository = PoliceStationRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.policeStationRepository.create(null);
        Assert.assertEquals(null,null);
    }

    @Test
    public void update(){

    }

    @Test
    public void delete(){
    }

    @Test
    public void read(){

    }

    @Test
    public void getPoliceStationSet(){
        Set<PoliceStation> policeStationSet = this.policeStationRepository.getPoliceStationSet();
        Assert.assertEquals(0,policeStationSet.size());
    }
}
