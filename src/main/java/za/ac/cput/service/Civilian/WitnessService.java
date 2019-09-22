package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Witness;
import za.ac.cput.service.impService;

public interface WitnessService extends impService<Witness, String> {
    Witness create(Witness witness);
}
