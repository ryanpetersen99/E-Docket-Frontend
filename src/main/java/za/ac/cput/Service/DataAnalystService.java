package za.ac.cput.Service;


import za.ac.cput.Domain.DataAnalyst;

import java.util.Set;

public interface DataAnalystService extends impService<DataAnalyst, String> {
    DataAnalyst create(DataAnalyst dataAnalyst);
}
