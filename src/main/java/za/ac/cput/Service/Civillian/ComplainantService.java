package za.ac.cput.Service.Civillian;

import za.ac.cput.Domain.Civillian.Complainant;
import za.ac.cput.Service.impService;

public interface ComplainantService extends impService<Complainant, String> {
    Complainant create(Complainant complainant);
}
