package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.Charge;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface ChargeService extends impService<Charge, String> {
    Set<Charge> getChargeSet();
}
