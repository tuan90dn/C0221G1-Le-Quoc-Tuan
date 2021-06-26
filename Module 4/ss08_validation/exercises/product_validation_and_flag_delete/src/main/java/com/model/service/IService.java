package com.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);


    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
    void deleteByFlag(Integer id);
    Page<T> findByName(String name,Pageable pageable);
}
