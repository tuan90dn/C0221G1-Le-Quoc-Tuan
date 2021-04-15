package bai12_java_collection_framework.bai_tap.luyen_tap_sd_arraylist_linkedlist;

public class Product implements Comparable<Product> {
    private int id;
    private String name;
    private double price;

    public Product() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        if (getPrice() > o.getPrice()) return 1;
        else if (getPrice() < o.getPrice()) return -1;
        else return 1;
    }
}

