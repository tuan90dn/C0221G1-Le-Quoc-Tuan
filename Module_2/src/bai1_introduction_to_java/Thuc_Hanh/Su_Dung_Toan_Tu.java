package bai1_introduction_to_java.Thuc_Hanh;
import java.sql.SQLOutput;
import java.util.Scanner;
public class Su_Dung_Toan_Tu {
    public static void main(String[] args) {
        float width;
        float height;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter width ");
        width=scanner.nextFloat();
        System.out.println("Enter height");
        height=scanner.nextFloat();
        float area=width*height;
        System.out.println("Area is "+area);

    }
}
