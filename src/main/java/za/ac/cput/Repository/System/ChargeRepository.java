package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.Charge;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ChargeRepository extends impRepository<Charge, String> {
    Set<Charge> getChargeSet();
}
