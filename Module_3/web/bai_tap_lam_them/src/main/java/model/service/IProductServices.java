package model.service;

import model.bean.Product;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IProductServices {
    public List<Product> selectAllProducts();
    public void insertProduct(Product product) throws SQLException;
    public Product selectProductByID(int id);
    public List<Product> selectProductByName(String name);
    public boolean deleteProduct(int id) throws SQLException;
    public boolean updateProduct(Product product) throws SQLException;


}
