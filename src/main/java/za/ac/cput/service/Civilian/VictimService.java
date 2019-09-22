package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Victim;
import za.ac.cput.service.impService;

public interface VictimService extends impService<Victim, String> {
    @Override
    Victim create(Victim victim);
}
