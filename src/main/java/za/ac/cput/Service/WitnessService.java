package za.ac.cput.Service;

import za.ac.cput.Domain.Witness;

import java.util.Set;

public interface WitnessService extends impService<Witness, String> {
    Witness create(Witness witness);
}
