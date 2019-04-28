package za.ac.cput.Service;


import za.ac.cput.Domain.Inspector;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface InspectorService extends impService<Inspector, String> {
    @Override
    Inspector create(Inspector inspector);
}
