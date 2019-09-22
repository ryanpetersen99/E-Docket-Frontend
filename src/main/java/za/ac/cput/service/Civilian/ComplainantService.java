package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Complainant;
import za.ac.cput.service.impService;

import java.util.Set;

public interface ComplainantService extends impService<Complainant, String> {
    Set<Complainant> getAll();
}
