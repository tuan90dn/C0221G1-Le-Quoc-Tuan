package com.model.repository;

import com.model.bean.Product;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class ProductRepository {
    static Map<Integer, Product> mapProducts=new HashMap<>();
    static {
        mapProducts.put(1,new Product(1,"tivi","10 000 000","new","Sony"));
        mapProducts.put(2,new Product(2,"tivi","10 000 000","new","Sony"));
        mapProducts.put(3,new Product(3,"tu lanh","15 000 000","old","toshiba"));
        mapProducts.put(4,new Product(4,"tu lanh","15 000 000","new","toshiba"));
        mapProducts.put(5,new Product(5,"dieu hoa nhiet do","12 000 000","old","panasonic"));

    }

    public List<Product> findAllProduct() {
        return new ArrayList<>(mapProducts.values());
    }


    public Product findProductById(int id) {
        return mapProducts.get(id);
    }
    public List<Product> findProductByName(String name) {
        List<Product> listProduct= findAllProduct();
        List<Product> listSearchProduct=new ArrayList<>();
        for (Product product:listProduct){
            if (product.nameOfProduct.equals(name)){
                listSearchProduct.add(product);
            }
        }
        return listSearchProduct;
    }


    public void saveProduct(Product product) {
        int idAutoIncrement= (int) (Math.random()*1000);
        product.setIdOfProduct(idAutoIncrement);
        mapProducts.put(product.getIdOfProduct(),product);
    }


    public void updateProduct(int id, Product product) {
        mapProducts.put(id,product);
    }


    public void deleteProduct(int id) {
        mapProducts.remove(id);
    }

}
