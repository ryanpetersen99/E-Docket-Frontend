package za.ac.cput.repository.Civilian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.factory.Civilian.ComplainantFactory;
import za.ac.cput.repository.implementation.Civillian.ComplainantRepositoryImplementation;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ComplainantRepositoryImplementationTest {

    @Autowired
    private ComplainantRepositoryImplementation complainantRepository;

    @Test
    public void ComplainantCreateTest() throws IOException{
        Complainant complainant = ComplainantFactory.getComplainant("99847328234","Jodi","Smit","Got Mugged");
        complainantRepository.create(complainant);
        Assert.assertNotNull(complainantRepository.getComplainantSet());
    }

    public void read() throws  IOException {
        Complainant complainant = ComplainantFactory.getComplainant("99847328234","Jodi","Smit","Got Mugged");
        complainantRepository.create(complainant);
        Assert.assertNotNull(complainantRepository.getComplainantSet());
        Complainant complainant1 = complainantRepository.read(complainant.getComplainantID());
        assertEquals(complainant,complainant1);
    }
}
