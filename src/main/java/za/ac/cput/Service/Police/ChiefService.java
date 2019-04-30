package za.ac.cput.Service.Police;

import za.ac.cput.Domain.Police.Chief;
import za.ac.cput.Service.impService;

public interface ChiefService extends impService<Chief, String> {
    Chief create(Chief chief);
}
