package za.ac.cput.service.Police;

import za.ac.cput.domain.Police.Officer;
import za.ac.cput.service.impService;

public interface OfficerService extends impService<Officer, String> {
    Officer create(Officer officer);
}
