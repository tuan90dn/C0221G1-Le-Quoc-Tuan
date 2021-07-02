package com.practice_02.model.service;

import com.practice_02.model.entity.Customer;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Customer customer);
    void insertWithStoredProcedure(String firstName,String lastName);
}
