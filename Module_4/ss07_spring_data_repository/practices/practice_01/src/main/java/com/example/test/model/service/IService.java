package com.example.test.model.service;

import com.example.test.model.entity.Customer;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(T t);
}
