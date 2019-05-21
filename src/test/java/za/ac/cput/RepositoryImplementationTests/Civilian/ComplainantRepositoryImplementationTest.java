package za.ac.cput.RepositoryImplementationTests.Civilian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.Domain.Civilian.Complainant;
import za.ac.cput.Factory.Civilian.ComplainantFactory;
import za.ac.cput.Repository.Civilian.ComplainantRepository;
import za.ac.cput.Repository.Implementation.Civillian.ComplainantRepositoryImplementation;

import java.io.IOException;
import java.util.Set;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ComplainantRepositoryImplementationTest {

    @Autowired
    private ComplainantRepository complainantRepository;
    private String complainantID;

    @Test
    public void ComplainantCreateTest() throws IOException{
        Complainant complainant = ComplainantFactory.getComplainant("99847328234","Jodi","Smit","Got Mugged");
        Complainant result = complainantRepository.create(complainant);
        complainantID = result.getComplainantID();
        Assert.assertNotNull(complainant);
    }

    public void read() throws  IOException {
        Complainant complainant = complainantRepository.read(complainantID);
        Assert.assertNotNull(complainant);
    }
}
