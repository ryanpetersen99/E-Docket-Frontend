package za.ac.cput.service.Police;

import za.ac.cput.domain.Police.Officer;
import za.ac.cput.service.impService;

import java.util.Set;

public interface OfficerService extends impService<Officer, String> {
    Set<Officer> getAll();
}
