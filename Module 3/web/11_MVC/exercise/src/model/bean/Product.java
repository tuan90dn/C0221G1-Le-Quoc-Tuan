package model.bean;

public class Product {
    public String idOfProduct;
    public String nameOfProduct;
    public String priceOfProduct;
    public String descriptionOfProduct;
    public String manufactoryOfProduct;

    public Product() {
    }

    public Product(String idOfProduct, String nameOfProduct, String priceOfProduct, String descriptionOfProduct, String manufactoryOfProduct) {
        this.idOfProduct = idOfProduct;
        this.nameOfProduct = nameOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.descriptionOfProduct = descriptionOfProduct;
        this.manufactoryOfProduct = manufactoryOfProduct;
    }

    public String getIdOfProduct() {
        return idOfProduct;
    }

    public void setIdOfProduct(String idOfProduct) {
        this.idOfProduct = idOfProduct;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(String priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public String getDescriptionOfProduct() {
        return descriptionOfProduct;
    }

    public void setDescriptionOfProduct(String descriptionOfProduct) {
        this.descriptionOfProduct = descriptionOfProduct;
    }

    public String getManufactoryOfProduct() {
        return manufactoryOfProduct;
    }

    public void setManufactoryOfProduct(String manufactoryOfProduct) {
        this.manufactoryOfProduct = manufactoryOfProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idOfProduct='" + idOfProduct + '\'' +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", priceOfProduct='" + priceOfProduct + '\'' +
                ", descriptionOfProduct='" + descriptionOfProduct + '\'' +
                ", manufactoryOfProduct='" + manufactoryOfProduct + '\'' +
                '}';
    }
}
