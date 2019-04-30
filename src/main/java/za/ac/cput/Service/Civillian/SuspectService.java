package za.ac.cput.Service.Civillian;

import za.ac.cput.Domain.Civillian.Suspect;
import za.ac.cput.Service.impService;

public interface SuspectService extends impService<Suspect, String> {
    Suspect create(Suspect suspect);
}
