package za.ac.cput.RepositoryImplementationTests.System;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.SolvedCase;
import za.ac.cput.Repository.Implementation.System.SolvedCaseRepositoryImplementation;
import za.ac.cput.Repository.System.SolvedCaseRepository;

import java.util.Set;


public class SolvedCaseRepositoryImplementationTest {

    private SolvedCaseRepository solvedCaseRepository;

    @Before
    public void setUp() throws Exception{
        this.solvedCaseRepository = SolvedCaseRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.solvedCaseRepository.create(null);
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
    public void getSolvedCaseSet(){
        Set<SolvedCase> solvedCaseSet = this.solvedCaseRepository.getSolvedCaseSet();
        Assert.assertEquals(1,solvedCaseSet.size());
    }
}
