package za.ac.cput.Service.Civillian;

import za.ac.cput.Domain.Civillian.Convict;
import za.ac.cput.Service.impService;

public interface ConvictService extends impService<Convict, String> {
    Convict create(Convict chief);
}
