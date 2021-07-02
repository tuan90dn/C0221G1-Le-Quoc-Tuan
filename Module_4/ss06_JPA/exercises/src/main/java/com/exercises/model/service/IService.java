package com.exercises.model.service;

import com.exercises.model.entity.Blog;


import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
    List<T> findByName(String name);
}
