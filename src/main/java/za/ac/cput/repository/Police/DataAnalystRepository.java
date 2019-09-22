package za.ac.cput.repository.Police;


import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface DataAnalystRepository extends impRepository<DataAnalyst, String> {
    Set<DataAnalyst> getDataAnalystSet();
}
