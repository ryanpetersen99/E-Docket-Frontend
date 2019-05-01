package za.ac.cput.ServiceImplementationTests.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Factory.System.PendingCaseFactory;
import za.ac.cput.Repository.Implementation.System.PendingCaseRepositoryImplementation;
import za.ac.cput.Repository.System.PendingCaseRepository;

import java.util.Set;


public class PendingCaseRepositoryImplementationTest {

    private PendingCaseRepository pendingCaseRepository;
    private PendingCase pendingCase;

    public PendingCase getSavedCase() {
        Set<PendingCase> pendingCaseSet = this.pendingCaseRepository.getPendingCaseSet();
        return pendingCaseSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
        this.pendingCase = PendingCaseFactory.getPendingCase("CASE14021922","Case relating to Mr Smith and Mrs Smith Divorce",1,"14/02/19");
    }

    @Test
    public void create(){
        PendingCase createdI = this.pendingCaseRepository.create(this.pendingCase);
        System.out.println("Successfully created Case" + "\n" + pendingCase);
        Assert.assertSame(createdI,this.pendingCase);
    }

    @Test
    public void update(){
        String id = "CASE14021910";
        PendingCase pendingCase =  new PendingCase.Builder().copy(getSavedCase()).caseID(id).build();
        System.out.println("Updating" + "\n" + pendingCase );
        PendingCase updatedID = this.pendingCaseRepository.update(pendingCase);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getCaseID());
    }

    @Test
    public void delete(){
        PendingCase caseSaved = getSavedCase();
        this.pendingCaseRepository.delete(getSavedCase().getCaseID());
    }

    @Test
    public void read(){
        PendingCase caseSaved = getSavedCase();
        System.out.println("Read case id" + "\n" + getSavedCase().getCaseID());
        PendingCase read = this.pendingCaseRepository.read(getSavedCase().getCaseID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedCase(),read);
    }

    @Test
    public void getCaseSet(){
        Set<PendingCase> caseSet = this.pendingCaseRepository.getPendingCaseSet();
        System.out.println("List of Cases Pending" + "\n" + caseSet);
    }
}
