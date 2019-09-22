package za.ac.cput.service.Civilian;

import za.ac.cput.domain.Civilian.Convict;
import za.ac.cput.service.impService;

public interface ConvictService extends impService<Convict, String> {
    Convict create(Convict chief);
}
