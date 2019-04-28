package za.ac.cput.RepositoryImplementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Domain.Evidence;
import za.ac.cput.Domain.Inspector;
import za.ac.cput.Repository.EvidenceRepository;
import za.ac.cput.Repository.Implementation.EvidenceRepositoryImplementation;
import za.ac.cput.Repository.Implementation.InspectorRepositoryImplementation;
import za.ac.cput.Repository.InspectorRepository;

import java.util.Set;


public class InspectorRepositoryImplementationTest {

    private InspectorRepository inspectorRepository;

    @Before
    public void setUp() throws Exception{
        this.inspectorRepository = InspectorRepositoryImplementation.getRepository();
    }

    @Test
    public void create(){
        this.inspectorRepository.create(null);
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
    public void getInspectorSet(){
        Set<Inspector> inspectorSet = this.inspectorRepository.getInspectorSet();
        Assert.assertEquals(1,inspectorSet.size());
    }
}
