package bai12_java_collection_framework.bai_tap.luyen_tap_sd_arraylist_linkedlist;
import java.util.*;

public class ProductManager {
    public static List<Product> listProduct=new ArrayList<>();
    Scanner scanner=new Scanner(System.in);
    public void addProduct(){
        System.out.println("Enter id: ");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.println("Enter name: ");
        String name=scanner.nextLine();
        System.out.println("Enter price: ");
        double price=scanner.nextDouble();
        Product product=new Product(id,name,price);
        listProduct.add(product);
    }
    public void display(){
        System.out.println(listProduct);

    }
    public void deleteProduct(){
        System.out.println("Enter id need to edit: ");
        int id=scanner.nextInt();        //
        listProduct.removeIf(temp -> temp.getId() == id);
    }
    public void searchProduct(){
//        scanner.nextLine();
        System.out.print("Enter name of the product:" );
        String nameSearch=scanner.nextLine();
        for (Product temp:listProduct){
            if (temp.getName().equals(nameSearch)){
                System.out.println(temp);
            }
        }
    }
    public void compareAugmentProduct(){
        Collections.sort(listProduct);
    }
    public void compareDiscountProduct(){
        Collections.sort(listProduct);
        Collections.reverse(listProduct);
    }
    public void editProduct(){
        System.out.println("Enter id need to edit: ");
        int id=scanner.nextInt();
        for (Product temp:listProduct){
            if (temp.getId()==id){
                scanner.nextLine();
                System.out.println("Enter name: ");
                temp.setName(scanner.nextLine());
                System.out.println("Enter price: ");
                temp.setPrice(scanner.nextDouble());

            }
        }
    }

    public static void main(String[] args) {
        Product product1=new Product(1,"tivi",10);
        Product product2=new Product(2,"tu lanh",5);
        Product product3=new Product(3,"dieu hoa",30);
        listProduct.add(product1);
        listProduct.add(product2);
        listProduct.add(product3);

        ProductManager productManager=new ProductManager();
        productManager.display();
        productManager.compareDiscountProduct();
//       productManager.editProduct();
//        System.out.println(listProduct);
//        productManager.display();
        productManager.display();
    }


}
