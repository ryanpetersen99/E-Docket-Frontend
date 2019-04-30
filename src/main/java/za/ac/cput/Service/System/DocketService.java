package za.ac.cput.Service.System;

import za.ac.cput.Domain.System.Docket;
import za.ac.cput.Service.impService;

import java.util.Set;

public interface DocketService extends impService<Docket, String> {
    Set<Docket> getDocketSet();
}
