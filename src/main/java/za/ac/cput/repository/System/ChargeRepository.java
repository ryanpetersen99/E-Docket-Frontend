package za.ac.cput.repository.System;

import za.ac.cput.domain.System.Charge;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface ChargeRepository extends impRepository<Charge, String> {
    Set<Charge> getChargeSet();
}
