package za.ac.cput.service.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.System.Docket;
import za.ac.cput.factory.System.DocketFactory;
import za.ac.cput.repository.System.DocketRepository;
import za.ac.cput.repository.implementation.System.DocketRepositoryImplementation;

import java.util.Set;


public class DocketServiceImplementationTest {

    private DocketRepository docketRepository;
    private Docket docket;
    private Docket docket2;

    public Docket getSavedDockets() {
        Set<Docket> docketSet = this.docketRepository.getDocketSet();
        return docketSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception {
        this.docketRepository = DocketRepositoryImplementation.getRepository();
        this.docket = DocketFactory.getDocket("CAS10009");
        this.docket2 = DocketFactory.getDocket("CAS10010");
    }

    @Test
    public void create() {
        Docket createdI = this.docketRepository.create(this.docket);
        Docket createdI2 = this.docketRepository.create(this.docket2);
        System.out.println("Successfully created Docket" + "\n" + docket);
        System.out.println("Successfully created Docket 2" + "\n" + docket2);
        Assert.assertSame(createdI, this.docket);
        Assert.assertSame(createdI2, this.docket2);
    }

    @Test
    public void update() {
        String id = "CAS10011";
        Docket docketU = new Docket.Builder().copy(getSavedDockets()).docketID(id).build();
        this.docketRepository.update(docketU);
        System.out.println("Updated" + "\n" + docketU);
        Assert.assertSame(id, docketU.getDocketID());
    }

    @Test
    public void delete() {
        Docket docketSaved = getSavedDockets();
        this.docketRepository.delete(docketSaved.getDocketID());
        getDocketSet();
    }

    @Test
    public void read() {
        Docket docketSaved = getSavedDockets();
        Docket read = this.docketRepository.read(docketSaved.getDocketID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedDockets(), read);
    }

    @Test
    public void getDocketSet() {
        Set<Docket> docketSet = this.docketRepository.getDocketSet();
        System.out.println("List of Dockets" + "\n" + docketSet);
        Assert.assertEquals(1, docketSet.size());
    }
}
