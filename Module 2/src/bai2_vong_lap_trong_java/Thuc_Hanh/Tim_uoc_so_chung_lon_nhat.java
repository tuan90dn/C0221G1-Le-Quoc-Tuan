package bai2_vong_lap_trong_java.Thuc_Hanh;
import java.util.Scanner;
public class Tim_uoc_so_chung_lon_nhat {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a: ");
        int a = input.nextInt();
        System.out.println("Enter b: ");
        int b = input.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0)
            System.out.println("No greatest common factor");
        while (a != b) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }
        System.out.println("Greatest common factor: " + a);
    }

}
