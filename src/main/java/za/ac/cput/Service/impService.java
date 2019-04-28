package za.ac.cput.Service;

public interface impService<Imp, ID> {

    Imp create(Imp imp);
    Imp update(Imp imp);
    void delete(ID id);
    Imp read(ID id);
}
