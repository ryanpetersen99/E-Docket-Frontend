package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.repository.Police.DataAnalystRepository;

import java.util.HashSet;
import java.util.Set;

@Repository("DataAnalystRepository")
public class DataAnalystRepositoryImplementation implements DataAnalystRepository {

    private static DataAnalystRepositoryImplementation dataAnalystRepImp = null;
    private Set<DataAnalyst> dataAnalystSet;

    private DataAnalystRepositoryImplementation() {
        this.dataAnalystSet = new HashSet<>();
    }

    private DataAnalyst findDataAnalyst(String daID) {
        return this.dataAnalystSet.stream()
                .filter(dataAnalyst -> dataAnalyst.getDaID().trim().equals(daID))
                .findAny()
                .orElse(null);
    }

    public static DataAnalystRepositoryImplementation getRepository() {
        if (dataAnalystRepImp == null) dataAnalystRepImp = new DataAnalystRepositoryImplementation();
        return dataAnalystRepImp;
    }

    @Override
    public DataAnalyst create(DataAnalyst dataAnalyst) {
        this.dataAnalystSet.add(dataAnalyst);
        return dataAnalyst;
    }

    @Override
    public DataAnalyst read(String daID) {
        return findDataAnalyst(daID);
    }

    @Override
    public DataAnalyst update(DataAnalyst dataAnalyst) {
        DataAnalyst delete = findDataAnalyst(dataAnalyst.getDaID());
        if (delete != null) {
            this.dataAnalystSet.remove(delete);
            return create(dataAnalyst);
        }
        return null;
    }

    @Override
    public void delete(String daID) {
        DataAnalyst dataAnalyst = findDataAnalyst(daID);
        if (dataAnalyst != null) {
            this.dataAnalystSet.remove(dataAnalyst);
        }
    }

    public Set<DataAnalyst> getDataAnalystSet() {
        return this.dataAnalystSet;
    }
}
