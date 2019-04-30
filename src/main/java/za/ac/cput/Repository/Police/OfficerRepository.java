package za.ac.cput.Repository.Police;

import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface OfficerRepository extends impRepository<Officer, String> {
    Set<Officer> getOfficerSet();
}
