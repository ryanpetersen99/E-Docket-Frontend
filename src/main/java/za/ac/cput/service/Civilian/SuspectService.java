package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.service.impService;

public interface SuspectService extends impService<Suspect, String> {
    Suspect create(Suspect suspect);
}
