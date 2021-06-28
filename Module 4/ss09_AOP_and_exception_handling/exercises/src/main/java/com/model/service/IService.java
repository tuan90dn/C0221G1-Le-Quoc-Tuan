package com.model.service;

import com.model.entity.BorrowBook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T t);

    void remove(Integer id);
    BorrowBook findBorrowBookByCode(String code);

//    Page<T> findByName(String name, Pageable pageable);
}
