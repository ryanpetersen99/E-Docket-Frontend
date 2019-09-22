package za.ac.cput.service.System.implementation;


import org.springframework.stereotype.Service;
import za.ac.cput.domain.System.Charge;
import za.ac.cput.repository.System.ChargeRepository;
import za.ac.cput.repository.implementation.System.ChargeRepositoryImplementation;
import za.ac.cput.service.System.ChargeService;

import java.util.Set;

@Service("ChargeServiceImplementation")
public class ChargeServiceImplementation implements ChargeService {

    private static ChargeServiceImplementation chargeServiceImplementation = null;
    private ChargeRepository chargeRepository;

    private ChargeServiceImplementation() {
        this.chargeRepository = ChargeRepositoryImplementation.getRepository();
    }

    public static ChargeServiceImplementation getRepository() {
        if (chargeServiceImplementation == null) chargeServiceImplementation = new ChargeServiceImplementation();
        return chargeServiceImplementation;
    }

    @Override
    public Charge create(Charge charge) {
        return this.chargeRepository.create(charge);
    }

    @Override
    public Charge read(String n) {
        return this.chargeRepository.read(n);
    }

    @Override
    public Charge update(Charge charge) {
        return this.chargeRepository.update(charge);
    }

    @Override
    public void delete(String n) {
        this.chargeRepository.delete(n);
    }

    public Set<Charge> getChargeSet() {
        return this.chargeRepository.getChargeSet();
    }
}
