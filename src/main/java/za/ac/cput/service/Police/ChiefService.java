package za.ac.cput.service.Police;

import za.ac.cput.domain.Police.Chief;
import za.ac.cput.service.impService;

public interface ChiefService extends impService<Chief, String> {
    Chief create(Chief chief);
}
