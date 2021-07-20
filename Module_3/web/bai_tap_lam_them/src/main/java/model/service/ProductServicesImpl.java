package model.service;

import model.bean.Product;
import model.repository.ProductRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.*;

public class ProductServicesImpl implements IProductServices {
    ProductRepository productRepository =new ProductRepository();

    @Override
    public List<Product> selectAllProducts() {
        return productRepository.selectAllProducts();
    }

    @Override
    public void insertProduct(Product product) throws SQLException {
        productRepository.insertProduct(product);
    }

    @Override
    public Product selectProductByID(int id) {
        return productRepository.selectProductByID(id);
    }

    @Override
    public List<Product> selectProductByName(String name) {
        return productRepository.selectProductByName(name);
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        return productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        return productRepository.updateProduct(product);
    }
}
