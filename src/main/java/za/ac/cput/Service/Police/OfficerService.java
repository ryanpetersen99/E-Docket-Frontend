package za.ac.cput.Service.Police;

import za.ac.cput.Domain.Police.Officer;
import za.ac.cput.Service.impService;

public interface OfficerService extends impService<Officer, String> {
    Officer create(Officer officer);
}
