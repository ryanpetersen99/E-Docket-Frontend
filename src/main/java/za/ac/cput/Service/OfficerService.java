package za.ac.cput.Service;

import za.ac.cput.Domain.Officer;

import java.util.Set;

public interface OfficerService extends impService<Officer, String> {
    Officer create(Officer officer);
}
