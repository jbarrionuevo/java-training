package edu.globant.day4.jdbc.exercises.dao;

import java.util.List;

public interface GenericDAO<PK, T> {

    PK create(T newInstance);

    T read(PK id);

    void update(T transientObject);

    void delete(T persistentObject);
    
    public T getByIndex(PK index);
    
    public List<T> getAll();
    
}
