package za.ac.cput.Service;

import za.ac.cput.Domain.Convict;
import za.ac.cput.Repository.impRepository;

import java.util.Set;

public interface ConvictService extends impService<Convict, String> {
    Convict create(Convict chief);
}
