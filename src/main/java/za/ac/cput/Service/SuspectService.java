package za.ac.cput.Service;

import za.ac.cput.Domain.Suspect;

import java.util.Set;

public interface SuspectService extends impService<Suspect, String> {
    Suspect create(Suspect suspect);
}
