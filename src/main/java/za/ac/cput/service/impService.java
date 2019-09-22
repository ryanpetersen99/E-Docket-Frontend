package za.ac.cput.service;

public interface impService<Imp, ID> {

    Imp create(Imp imp);

    Imp update(Imp imp);

    void delete(ID id);

    Imp read(ID id);
}
