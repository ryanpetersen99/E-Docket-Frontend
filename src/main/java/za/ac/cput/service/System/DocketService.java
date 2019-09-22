package za.ac.cput.service.System;

import za.ac.cput.domain.System.Docket;
import za.ac.cput.service.impService;

import java.util.Set;

public interface DocketService extends impService<Docket, String> {
    Set<Docket> getDocketSet();
}
