package za.ac.cput.repository.System;

import za.ac.cput.domain.System.Docket;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface DocketRepository extends impRepository<Docket, String> {
    Set<Docket> getDocketSet();
}
