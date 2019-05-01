package za.ac.cput.Service.Civilian;

import za.ac.cput.Domain.Civilian.Victim;
import za.ac.cput.Service.impService;

public interface VictimService extends impService<Victim, String> {
    @Override
    Victim create(Victim victim);
}
