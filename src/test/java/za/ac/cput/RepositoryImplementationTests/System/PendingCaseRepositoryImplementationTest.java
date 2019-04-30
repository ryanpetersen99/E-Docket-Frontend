package za.ac.cput.RepositoryImplementationTests.System;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.System.PendingCase;
import za.ac.cput.Repository.System.PendingCaseRepository;
import za.ac.cput.Repository.Implementation.System.PendingCaseRepositoryImplementation;

import java.util.Set;


public class PendingCaseRepositoryImplementationTest {

    private PendingCaseRepository pendingCaseRepository;

    @Before
    public void setUp() throws Exception{
        this.pendingCaseRepository = PendingCaseRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.pendingCaseRepository.create(null);
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
    public void getCaseSet(){
        Set<PendingCase> caseSet = this.pendingCaseRepository.getPendingCaseSet();
        Assert.assertEquals(1,caseSet.size());
    }
}
