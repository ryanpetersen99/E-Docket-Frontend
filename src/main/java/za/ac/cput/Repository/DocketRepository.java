package za.ac.cput.Repository;

import za.ac.cput.Domain.Docket;

import java.util.Set;

public interface DocketRepository extends impRepository<Docket, String> {
    Set<Docket> getDocketSet();
}
