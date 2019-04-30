package za.ac.cput.Service.Implementation;

import za.ac.cput.Domain.Police.DataAnalyst;
import za.ac.cput.Repository.Police.DataAnalystRepository;
import za.ac.cput.Repository.Implementation.Police.DataAnalystRepositoryImplementation;
import za.ac.cput.Service.Police.DataAnalystService;

import java.util.Set;

public class DataAnalystServiceImplementation implements DataAnalystService{

    private static DataAnalystServiceImplementation daService = null;
    private DataAnalystRepository dataAnalystRepository;

    private DataAnalystServiceImplementation(){
        this.dataAnalystRepository = DataAnalystRepositoryImplementation.getRepository();
    }

    public static DataAnalystServiceImplementation getDaService(){
        if(daService == null)daService = new DataAnalystServiceImplementation();
        return daService;
    }

    @Override
    public DataAnalyst create(DataAnalyst dataAnalyst) { return this.dataAnalystRepository.create(dataAnalyst); }

    @Override
    public DataAnalyst read(String d) {return this.dataAnalystRepository.read(d); }

    @Override
    public DataAnalyst update(DataAnalyst dataAnalyst) {
        return this.dataAnalystRepository.update(dataAnalyst);
    }

    @Override
    public void delete(String d) { this.dataAnalystRepository.delete(d);}

    public Set<DataAnalyst> getDataAnalystSet() {
        return this.dataAnalystRepository.getDataAnalystSet();
    }
}
