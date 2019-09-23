package za.ac.cput.repository.implementation.Police;

import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Police.DataAnalyst;
import za.ac.cput.repository.Police.DataAnalystRepository;

import java.util.*;

@Repository("DataAnalystRepository")
public class DataAnalystRepositoryImplementation implements DataAnalystRepository {

    private static DataAnalystRepositoryImplementation compRepImp = null;
    private Map<String, DataAnalyst> daSet;

    private DataAnalystRepositoryImplementation() {
        this.daSet = new HashMap<>();
    }

    public static DataAnalystRepositoryImplementation getRepository() {
        if (compRepImp == null) compRepImp = new DataAnalystRepositoryImplementation();
        return compRepImp;
    }

//    private DataAnalyst findDataAnalyst(String daID) {
//        return this.daSet.stream()
//                .filter(da -> da.getDataAnalystID().trim().equals(daID))
//                .findAny()
//                .orElse(null);
//    }

    @Override
    public DataAnalyst create(DataAnalyst da) {
        if (read(da.getDaID()) == null) {
            this.daSet.put(da.getDaID(), da);
        }
        return da;
    }

    @Override
    public DataAnalyst read(String id) {
        return this.daSet.get(id);
    }

    @Override
    public DataAnalyst update(DataAnalyst da) {
        if (read(da.getDaID()) != null) {
            daSet.replace(da.getDaID(), da);
        }
        return da;
    }

    @Override
    public void delete(String id) {
        DataAnalyst da = read(id);
        this.daSet.remove(id, da);

    }

    public Set<DataAnalyst> getDataAnalystSet() {
        Collection<DataAnalyst> da = this.daSet.values();
        Set<DataAnalyst> set = new HashSet<>();
        set.addAll(da);
        return set;
    }
}