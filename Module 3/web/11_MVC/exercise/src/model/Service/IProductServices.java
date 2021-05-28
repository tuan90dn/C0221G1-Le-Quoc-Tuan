package model.Service;

import model.bean.Product;

import java.util.ArrayList;
import java.util.List;

public interface IProductServices {
    List<Product> findAllProduct();
    Product findProductById(String id);
    Product findProductByName(String name);
    void saveProduct(Product product);
    void updateProduct(String id,Product product);
    void deleteProduct(String id);
}
