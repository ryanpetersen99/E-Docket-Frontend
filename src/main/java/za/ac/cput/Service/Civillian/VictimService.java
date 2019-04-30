package za.ac.cput.Service.Civillian;

import za.ac.cput.Domain.Civillian.Victim;
import za.ac.cput.Service.impService;

public interface VictimService extends impService<Victim, String> {
    @Override
    Victim create(Victim victim);
}
