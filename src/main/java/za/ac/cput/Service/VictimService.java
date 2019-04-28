package za.ac.cput.Service;

import za.ac.cput.Domain.Victim;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface VictimService extends impService<Victim, String> {
    @Override
    Victim create(Victim victim);
}
