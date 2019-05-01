package za.ac.cput.Service.Civilian;

import za.ac.cput.Domain.Civilian.Convict;
import za.ac.cput.Service.impService;

public interface ConvictService extends impService<Convict, String> {
    Convict create(Convict chief);
}
