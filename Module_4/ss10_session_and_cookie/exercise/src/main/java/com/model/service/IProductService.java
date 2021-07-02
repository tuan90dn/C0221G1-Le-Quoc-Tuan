package com.model.service;

import com.model.entity.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product> findAll();
    Product findById(Long id);
}
