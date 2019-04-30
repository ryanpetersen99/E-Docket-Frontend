package za.ac.cput.Service.Police;


import za.ac.cput.Domain.Police.Inspector;
import za.ac.cput.Service.impService;

public interface InspectorService extends impService<Inspector, String> {
    @Override
    Inspector create(Inspector inspector);
}
