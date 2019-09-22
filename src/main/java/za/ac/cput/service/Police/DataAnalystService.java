package za.ac.cput.service.Police;


import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.service.impService;

public interface DataAnalystService extends impService<DataAnalyst, String> {
    DataAnalyst create(DataAnalyst dataAnalyst);
}
