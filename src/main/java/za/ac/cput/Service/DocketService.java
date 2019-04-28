package za.ac.cput.Service;

import za.ac.cput.Domain.Docket;

import java.util.Set;

public interface DocketService extends impService<Docket, String> {
    Set<Docket> getDocketSet();
}
