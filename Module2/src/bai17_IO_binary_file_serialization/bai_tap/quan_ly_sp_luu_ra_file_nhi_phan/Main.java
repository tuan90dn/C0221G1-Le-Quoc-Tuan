package bai17_IO_binary_file_serialization.bai_tap.quan_ly_sp_luu_ra_file_nhi_phan;

import bai17_IO_binary_file_serialization.thuc_hanh.doc_va_ghi_danh_sach_sinh_vien.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void writeToFile(String path, List<Product> products) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<Product> readDataFromFile(String path){
        List<Product> products = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return products;
    }

    public static void main(String[] args) {
        List<Product> products=readDataFromFile("product.txt");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input iđ of product: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Input name of product: ");
        String name=scanner.nextLine();
        System.out.println("Input manufacturer of product: ");
        String manufacturer=scanner.nextLine();
        System.out.println("Input price of product: ");
        double price=Double.parseDouble(scanner.nextLine());
        System.out.println("Input description other of product: ");
        String description=scanner.nextLine();
        products.add(new Product(id,name,manufacturer,price,description));
        writeToFile("product.txt", products);

        List<Product> productDataFromFile = readDataFromFile("product.txt");
        for (Product product : productDataFromFile){
            System.out.println(product);
        }
    }
}
