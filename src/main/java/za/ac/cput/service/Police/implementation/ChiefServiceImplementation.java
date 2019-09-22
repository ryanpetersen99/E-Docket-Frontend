package za.ac.cput.service.Police.implementation;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.Police.Chief;
import za.ac.cput.repository.Police.ChiefRepository;
import za.ac.cput.repository.implementation.Police.ChiefRepositoryImplementation;
import za.ac.cput.service.Police.ChiefService;

import java.util.Set;

@Service("ChiefServiceImplementation")
public class ChiefServiceImplementation implements ChiefService {

    private static ChiefServiceImplementation chiefService = null;
    private ChiefRepository chiefRepository;

    private ChiefServiceImplementation() {
        this.chiefRepository = ChiefRepositoryImplementation.getRepository();
    }

    public static ChiefServiceImplementation getChiefService() {
        if (chiefService == null) chiefService = new ChiefServiceImplementation();
        return chiefService;
    }

    @Override
    public Chief create(Chief chief) {
        return this.create(chief);
    }

    @Override
    public Chief read(String c) {
        return this.read(c);
    }

    @Override
    public Chief update(Chief chief) {
        return this.update(chief);
    }

    @Override
    public void delete(String c) {
        this.delete(c);
    }

    public Set<Chief> getChiefSet() {
        return this.chiefRepository.getChiefSet();
    }
}
