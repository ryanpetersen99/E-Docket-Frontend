package za.ac.cput.Repository;

import za.ac.cput.Domain.Charge;

import java.util.Set;

public interface ChargeRepository extends impRepository<Charge, String> {
    Set<Charge> getChargeSet();
}
