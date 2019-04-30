package za.ac.cput.Repository.System;

import za.ac.cput.Domain.System.Docket;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface DocketRepository extends impRepository<Docket, String> {
    Set<Docket> getDocketSet();
}
