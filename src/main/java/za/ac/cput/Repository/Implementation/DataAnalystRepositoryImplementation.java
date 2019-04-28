package za.ac.cput.Repository.Implementation;

import za.ac.cput.Domain.DataAnalyst;
import za.ac.cput.Repository.DataAnalystRepository;

import java.util.HashSet;
import java.util.Set;

public class DataAnalystRepositoryImplementation implements DataAnalystRepository{

    private static DataAnalystRepositoryImplementation dataAnalystRepImp = null;
    private Set<DataAnalyst> dataAnalystSet;

    private DataAnalystRepositoryImplementation(){
        this.dataAnalystSet = new HashSet<>();
    }

    public static DataAnalystRepositoryImplementation getRepository(){
        if(dataAnalystRepImp == null)dataAnalystRepImp = new DataAnalystRepositoryImplementation();
        return dataAnalystRepImp;
    }

    @Override
    public DataAnalyst create(DataAnalyst dataAnalyst) {
        this.dataAnalystSet.add(dataAnalyst);
        return dataAnalyst;
    }

    @Override
    public DataAnalyst read(String daID) {
        return null;
    }

    @Override
    public DataAnalyst update(DataAnalyst dataAnalyst) {
        return dataAnalyst;
    }

    @Override
    public void delete(String daID) {

    }

    public Set<DataAnalyst> getDataAnalystSet() {
        return this.dataAnalystSet;
    }
}
