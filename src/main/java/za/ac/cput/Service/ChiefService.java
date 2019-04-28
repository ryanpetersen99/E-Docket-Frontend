package za.ac.cput.Service;

import za.ac.cput.Domain.Chief;

public interface ChiefService extends impService<Chief, String> {
    Chief create(Chief chief);
}
