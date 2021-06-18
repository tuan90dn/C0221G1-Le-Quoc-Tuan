package com.model.service;

import com.model.bean.Product;

import java.util.List;

public interface IProductServices {
    List<Product> findAllProduct();

    void saveProduct(Product product);

    Product findProductById(int id);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);
    List<Product> findProductByName(String name);

}
