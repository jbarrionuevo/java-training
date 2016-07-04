package edu.globant.IONSolid.dataaccess;

public interface GenericDAO <T, PK> {

    PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
}
