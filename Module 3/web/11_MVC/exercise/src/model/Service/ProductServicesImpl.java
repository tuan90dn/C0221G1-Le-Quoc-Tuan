package model.Service;

import model.bean.Product;
import model.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductServicesImpl implements IProductServices {
    ProductRepository productRepository=new ProductRepository();


    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAllProduct();
    }

    @Override
    public Product findProductById(String id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        ArrayList<Product> productList=(ArrayList<Product>) findAllProduct();
        ArrayList<Product> listProductResult=new ArrayList<>();
        for (Product product:productList){
            if (product.getNameOfProduct().equals(name)){
                listProductResult.add(product);
            }
        }
        return listProductResult;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(String id, Product product) {
        productRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
