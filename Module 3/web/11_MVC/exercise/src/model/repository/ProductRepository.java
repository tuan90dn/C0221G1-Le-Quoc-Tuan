package model.repository;

import model.bean.Product;

import java.util.*;

public class ProductRepository {
    static Map<String, Product> mapProducts=new HashMap<>();
    static {
        mapProducts.put("1",new Product("1","tivi","10 000 000","nhập khẩu","Sony"));
        mapProducts.put("2",new Product("2","tivi","10 000 000","nhập khẩu","Sony"));
        mapProducts.put("3",new Product("3","tu lanh","15 000 000","nhập khẩu","toshiba"));
        mapProducts.put("4",new Product("4","tu lanh","15 000 000","nhập khẩu","toshiba"));
        mapProducts.put("5",new Product("5","dieu hoa nhiet do","12 000 000","nội địa","panasonic"));

    }

    public List<Product> findAllProduct() {
        return new ArrayList<>(mapProducts.values());
    }


    public Product findProductById(String id) {
        return mapProducts.get(id);
    }


    public void saveProduct(Product product) {
        mapProducts.put(product.getIdOfProduct(),product);
    }


    public void updateProduct(String id, Product product) {
        mapProducts.put(id,product);
    }


    public void deleteProduct(String id) {
        mapProducts.remove(id);
    }
}
