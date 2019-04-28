package za.ac.cput.Repository;

public interface impRepository<Imp, ID> {

    Imp create(Imp imp);
    Imp update(Imp imp);
    void delete(ID id);
    Imp read(ID id);
}
