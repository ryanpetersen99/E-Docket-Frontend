package za.ac.cput.Repository;


import za.ac.cput.Domain.DataAnalyst;

import java.util.Set;

public interface DataAnalystRepository extends impRepository<DataAnalyst, String> {
    Set<DataAnalyst> getDataAnalystSet();
}
