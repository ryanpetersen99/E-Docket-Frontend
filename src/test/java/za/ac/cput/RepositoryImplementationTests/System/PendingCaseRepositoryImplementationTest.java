package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Factory.System.PendingCaseFactory;
import za.ac.cput.Repository.System.PendingCaseRepository;
import za.ac.cput.Repository.Implementation.System.PendingCaseRepositoryImplementation;

import java.util.Set;


public class PendingCaseRepositoryImplementationTest {

    private PendingCaseRepository pendingCaseRepository;
    private PendingCase pendingCase;
    private PendingCase pendingCase2;

    public PendingCase getSavedCase() {
        Set<PendingCase> pendingCaseSet = this.pendingCaseRepository.getPendingCaseSet();
        return pendingCaseSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
        this.pendingCase = PendingCaseFactory.getPendingCase("CASE14021922","Case relating to Mr Smith and Mrs Smith Divorce",1,"14/02/19");
        this.pendingCase2 = PendingCaseFactory.getPendingCase("CASE14021923","Case relating to Mr Jones and Mrs Jones Divorce",1,"14/02/19");
    }

    @Test
    public void create(){
        PendingCase createdI = this.pendingCaseRepository.create(this.pendingCase);
        PendingCase createdI2 = this.pendingCaseRepository.create(this.pendingCase2);
        System.out.println("Successfully created Case" + "\n" + pendingCase);
        System.out.println("Successfully created Case 2" + "\n" + pendingCase2);
        Assert.assertSame(createdI,this.pendingCase);
        Assert.assertSame(createdI2,this.pendingCase2);
    }

    @Test
    public void update(){
        String id = "CASE14021910";
        PendingCase pendingCase =  new PendingCase.Builder().copy(getSavedCase()).caseID(id).build();
        this.pendingCaseRepository.update(pendingCase);
        System.out.println("Updated" + "\n" + pendingCase);
        Assert.assertSame(id,pendingCase.getCaseID());
    }

    @Test
    public void delete(){
        PendingCase caseSaved = getSavedCase();
        this.pendingCaseRepository.delete(caseSaved.getCaseID());
        getCaseSet();
    }

    @Test
    public void read(){
        PendingCase caseSaved = getSavedCase();
        PendingCase read = this.pendingCaseRepository.read(caseSaved.getCaseID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedCase(),read);
    }

    @Test
    public void getCaseSet(){
        Set<PendingCase> caseSet = this.pendingCaseRepository.getPendingCaseSet();
        System.out.println("List of Cases Pending" + "\n" + caseSet);
        Assert.assertEquals(1,caseSet.size());
    }
}
