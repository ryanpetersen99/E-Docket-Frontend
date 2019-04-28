package za.ac.cput.Service;

import za.ac.cput.Domain.Complainant;

import java.util.Set;

public interface ComplainantService extends impService<Complainant, String> {
    Complainant create(Complainant complainant);
}
