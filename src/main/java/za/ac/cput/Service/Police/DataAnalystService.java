package za.ac.cput.Service.Police;


import za.ac.cput.Domain.Police.DataAnalyst;
import za.ac.cput.Service.impService;

public interface DataAnalystService extends impService<DataAnalyst, String> {
    DataAnalyst create(DataAnalyst dataAnalyst);
}
