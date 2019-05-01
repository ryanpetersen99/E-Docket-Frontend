package za.ac.cput.Service.Civilian;

import za.ac.cput.Domain.Civilian.Witness;
import za.ac.cput.Service.impService;

public interface WitnessService extends impService<Witness, String> {
    Witness create(Witness witness);
}
