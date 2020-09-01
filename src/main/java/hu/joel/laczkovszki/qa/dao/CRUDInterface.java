package hu.joel.laczkovszki.qa.dao;

import java.util.List;

public interface CRUDInterface <T>{
    void add (T t);

    T find (int id);

    void remove (int id);

    void update (int id, T t);

    List<T> getAll ();
}
