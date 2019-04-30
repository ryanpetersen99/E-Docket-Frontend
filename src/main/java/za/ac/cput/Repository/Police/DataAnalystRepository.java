package za.ac.cput.Repository.Police;


import za.ac.cput.Domain.Police.DataAnalyst;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface DataAnalystRepository extends impRepository<DataAnalyst, String> {
    Set<DataAnalyst> getDataAnalystSet();
}
