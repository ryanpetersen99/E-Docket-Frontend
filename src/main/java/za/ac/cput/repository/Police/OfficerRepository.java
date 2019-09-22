package za.ac.cput.repository.Police;

import za.ac.cput.domain.Police.Officer;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface OfficerRepository extends impRepository<Officer, String> {
    Set<Officer> getOfficerSet();
}
