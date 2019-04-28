package za.ac.cput.Repository;


import za.ac.cput.Domain.Inspector;

import java.util.Set;

public interface InspectorRepository extends impRepository<Inspector, String> {
    Set<Inspector> getInspectorSet();
}
