package za.ac.cput.Service;

import za.ac.cput.Domain.Charge;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ChargeService extends impService<Charge, String> {
    Set<Charge> getChargeSet();
}
