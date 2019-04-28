package za.ac.cput.Repository;

import za.ac.cput.Domain.Officer;

import java.util.Set;

public interface OfficerRepository extends impRepository<Officer, String> {
    Set<Officer> getOfficerSet();
}
