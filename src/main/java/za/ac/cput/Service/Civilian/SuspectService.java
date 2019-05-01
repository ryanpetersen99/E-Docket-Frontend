package za.ac.cput.Service.Civilian;

import za.ac.cput.Domain.Civilian.Suspect;
import za.ac.cput.Service.impService;

public interface SuspectService extends impService<Suspect, String> {
    Suspect create(Suspect suspect);
}
