package za.ac.cput.RepositoryImplementationTests.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Factory.System.SolvedCaseFactory;
import za.ac.cput.Repository.Implementation.System.SolvedCaseRepositoryImplementation;
import za.ac.cput.Repository.System.SolvedCaseRepository;

import java.util.Set;


public class SolvedCaseRepositoryImplementationTest {

    private SolvedCaseRepository solvedCaseRepository;
    private SolvedCase solvedCase;

    public SolvedCase getSavedCase() {
        Set<SolvedCase> solvedCaseSet = this.solvedCaseRepository.getSolvedCaseSet();
        return solvedCaseSet.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.solvedCaseRepository = SolvedCaseRepositoryImplementation.getRepository();
        this.solvedCase = SolvedCaseFactory.getSolvedCase("CASE14021922","Case relating to Mr Smith and Mrs Smith Divorce",1,"14/02/19");
    }

    @Test
    public void create(){
        SolvedCase createdI = this.solvedCaseRepository.create(this.solvedCase);
        System.out.println("Successfully created Case" + "\n" + solvedCase);
        Assert.assertSame(createdI,this.solvedCase);
    }

    @Test
    public void update(){
        String id = "CASE14021910";
        SolvedCase solvedCase =  new SolvedCase.Builder().copy(getSavedCase()).caseID(id).build();
        System.out.println("Updating" + "\n" + solvedCase );
        SolvedCase updatedID = this.solvedCaseRepository.update(solvedCase);
        System.out.println("Updated" + "\n" + updatedID);
        Assert.assertSame(id,updatedID.getCaseID());
    }

    @Test
    public void delete(){
        SolvedCase caseSaved = getSavedCase();
        this.solvedCaseRepository.delete(getSavedCase().getCaseID());
    }

    @Test
    public void read(){
        SolvedCase caseSaved = getSavedCase();
        System.out.println("Read case id" + "\n" + getSavedCase().getCaseID());
        SolvedCase read = this.solvedCaseRepository.read(getSavedCase().getCaseID());
        System.out.println("Read" + "\n" + read);
        Assert.assertEquals(getSavedCase(),read);
    }

    @Test
    public void getCaseSet(){
        Set<SolvedCase> caseSet = this.solvedCaseRepository.getSolvedCaseSet();
        System.out.println("List of Cases Pending" + "\n" + caseSet);
    }
}
