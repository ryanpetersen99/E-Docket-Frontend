package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Suspect;
import za.ac.cput.service.impService;

import java.util.Set;

public interface SuspectService extends impService<Suspect, String> {
    Set<Suspect> getAll();
}
