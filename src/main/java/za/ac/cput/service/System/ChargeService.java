package za.ac.cput.service.System;

import za.ac.cput.domain.System.Charge;
import za.ac.cput.service.impService;

import java.util.Set;

public interface ChargeService extends impService<Charge, String> {
    Set<Charge> getChargeSet();
}
