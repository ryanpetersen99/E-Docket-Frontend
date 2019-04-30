package za.ac.cput.Repository.Police;


import za.ac.cput.Domain.Police.Inspector;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface InspectorRepository extends impRepository<Inspector, String> {
    Set<Inspector> getInspectorSet();
}
