package za.ac.cput.service.Police;


import za.ac.cput.domain.Police.Inspector;
import za.ac.cput.service.impService;

public interface InspectorService extends impService<Inspector, String> {
    @Override
    Inspector create(Inspector inspector);
}
