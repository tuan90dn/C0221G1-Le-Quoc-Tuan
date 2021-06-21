package com.model.repository;

import java.util.List;

public interface IRepository<T> {
    List<T> findAll();
    T findById(int id);
    void save(T model);
    void remove(int id);
}
