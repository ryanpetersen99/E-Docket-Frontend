package za.ac.cput.Service.Civilian;

import za.ac.cput.Domain.Civilian.Complainant;
import za.ac.cput.Service.impService;

public interface ComplainantService extends impService<Complainant, String> {
    Complainant create(Complainant complainant);
}
