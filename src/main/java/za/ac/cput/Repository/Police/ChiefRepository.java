package za.ac.cput.Repository.Police;

import za.ac.cput.Domain.Police.Chief;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ChiefRepository extends impRepository<Chief, String> {
    Set<Chief> getChiefSet();
}
