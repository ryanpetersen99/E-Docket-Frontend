package za.ac.cput.Service.Civillian;

import za.ac.cput.Domain.Civillian.Witness;
import za.ac.cput.Service.impService;

public interface WitnessService extends impService<Witness, String> {
    Witness create(Witness witness);
}
