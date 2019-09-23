package za.ac.cput.service.System.implementation;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.Docket;
import za.ac.cput.repository.System.DocketRepository;
import za.ac.cput.repository.implementation.System.DocketRepositoryImplementation;
import za.ac.cput.service.System.DocketService;

import java.util.Set;

@Service("DocketServiceImplementation")
public class DocketServiceImplementation implements DocketService {

    private static DocketServiceImplementation docketService = null;
    private DocketRepository docketRepository;

    private DocketServiceImplementation() {
        this.docketRepository = DocketRepositoryImplementation.getRepository();
    }

    public static DocketServiceImplementation getDocketService() {
        if (docketService == null) docketService = new DocketServiceImplementation();
        return docketService;
    }

    @Override
    public Docket create(Docket docket) {
        return this.docketRepository.create(docket);
    }

    @Override
    public Docket read(String d) {
        return this.docketRepository.read(d);
    }

    @Override
    public Docket update(Docket docket) {
        return this.docketRepository.update(docket);
    }

    @Override
    public void delete(String d) {
        this.docketRepository.delete(d);
    }

    public Set<Docket> getDocketSet() {
        return this.docketRepository.getDocketSet();
    }
}
