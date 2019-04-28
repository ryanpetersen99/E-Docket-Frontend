package za.ac.cput.Repository;

import za.ac.cput.Domain.Chief;

import java.util.Set;

public interface ChiefRepository extends impRepository<Chief, String> {
    Set<Chief> getChiefSet();
}
