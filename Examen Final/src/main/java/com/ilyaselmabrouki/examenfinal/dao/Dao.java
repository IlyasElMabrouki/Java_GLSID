package com.ilyaselmabrouki.examenfinal.dao;

import java.util.List;

public interface Dao<T,U>{
    List<T> findAll();
    T findById(U id);
    void save(T o);
    void delete(U id);
    void update(T o, U id);
}
