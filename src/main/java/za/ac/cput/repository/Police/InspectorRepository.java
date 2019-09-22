package za.ac.cput.repository.Police;


import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface InspectorRepository extends impRepository<Inspector, String> {
    Set<Inspector> getInspectorSet();
}
