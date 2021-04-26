package bai17_IO_binary_file_serialization.bai_tap.quan_ly_sp_luu_ra_file_nhi_phan;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String nameOfProduct;
    private String manufacturerOfProduct;
    private double priceOfProduct;
    private String descriptionOther;

    public Product() {
    }

    public Product(int id, String nameOfProduct, String manufacturerOfProduct, double priceOfProduct, String descriptionOther) {
        this.id = id;
        this.nameOfProduct = nameOfProduct;
        this.manufacturerOfProduct = manufacturerOfProduct;
        this.priceOfProduct = priceOfProduct;
        this.descriptionOther = descriptionOther;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfProduct() {
        return nameOfProduct;
    }

    public void setNameOfProduct(String nameOfProduct) {
        this.nameOfProduct = nameOfProduct;
    }

    public String getManufacturerOfProduct() {
        return manufacturerOfProduct;
    }

    public void setManufacturerOfProduct(String manufacturerOfProduct) {
        this.manufacturerOfProduct = manufacturerOfProduct;
    }

    public double getPriceOfProduct() {
        return priceOfProduct;
    }

    public void setPriceOfProduct(double priceOfProduct) {
        this.priceOfProduct = priceOfProduct;
    }

    public String getDescriptionOther() {
        return descriptionOther;
    }

    public void setDescriptionOther(String descriptionOther) {
        this.descriptionOther = descriptionOther;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameOfProduct='" + nameOfProduct + '\'' +
                ", manufacturerOfProduct='" + manufacturerOfProduct + '\'' +
                ", priceOfProduct=" + priceOfProduct +
                ", descriptionOther='" + descriptionOther + '\'' +
                '}';
    }
}
