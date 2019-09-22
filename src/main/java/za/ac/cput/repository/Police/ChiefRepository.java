package za.ac.cput.repository.Police;

import za.ac.cput.domain.Police.Chief;
import za.ac.cput.repository.impRepository;

import java.util.Set;

public interface ChiefRepository extends impRepository<Chief, String> {
    Set<Chief> getChiefSet();
}
