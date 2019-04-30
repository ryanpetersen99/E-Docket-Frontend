package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.Docket;
import za.ac.cput.Factory.System.DocketFactory;
import za.ac.cput.Repository.System.DocketRepository;
import za.ac.cput.Repository.Implementation.System.DocketRepositoryImplementation;

import javax.print.Doc;
import java.util.Set;


public class DocketRepositoryImplementationTest {

    private DocketRepository docketRepository;
    private Docket docket;

    public Docket getSavedDockets() {
        Set<Docket> docketSet = this.docketRepository.getDocketSet();
        return docketSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.docketRepository = DocketRepositoryImplementation.getRepository();
        this.docket = DocketFactory.getDocket("CAS10009");
    }

    @Test
    public void create(){
        Docket createdI = this.docketRepository.create(this.docket);
        System.out.println("Successfully created Docket" + "\n" + docket);
        Assert.assertSame(createdI,this.docket);
    }

    @Test
    public void update(){
        String id = "CAS10010";
        Docket docket =  new Docket.Builder().copy(getSavedDockets()).docketID(id).build();
        System.out.println("Updating" + "\n" + docket );
        Docket updatedID = this.docketRepository.update(docket);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getDocketID());
    }

    @Test
    public void delete(){
        Docket docketSaved = getSavedDockets();
        this.docketRepository.delete(getSavedDockets().getDocketID());
    }

    @Test
    public void read(){
        Docket docketSaved = getSavedDockets();
        System.out.println("Read docket id" + "\n" + getSavedDockets().getDocketID());
        Docket read = this.docketRepository.read(docketSaved.getDocketID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedDockets(),read);
    }

    @Test
    public void getDocketSet(){
        Set<Docket> docketSet = this.docketRepository.getDocketSet();
        System.out.println("List of Dockets" + "\n" + docketSet);
    }
}
