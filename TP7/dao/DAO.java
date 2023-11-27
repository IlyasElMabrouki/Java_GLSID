package com.ilyaselmabrouki.tp8.dao;

import java.util.List;

public interface DAO<T,U>{
    void save(T o);
    void removeById(U id);
    T getById(U id);
    List<T> getAll();
}
