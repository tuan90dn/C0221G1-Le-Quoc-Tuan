package com.exercises.model.service;

import com.exercises.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface IService<T> {
    Page<T> findAll(Pageable pageable);


    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
    List<T> findByName(String name);
}
