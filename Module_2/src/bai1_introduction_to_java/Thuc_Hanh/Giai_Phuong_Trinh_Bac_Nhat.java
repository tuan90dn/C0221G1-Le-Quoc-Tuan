package bai1_introduction_to_java.Thuc_Hanh;
import java.util.Scanner;
public class Giai_Phuong_Trinh_Bac_Nhat {
    public static void main(String[] args) {
        System.out.println("Liner Equation Resolver");
        System.out.println("Given a equation as 'a*x+b=c',please enter constants:");
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input a ");
        double a=scanner.nextDouble();
        System.out.println("Input b");
        double b=scanner.nextDouble();
        System.out.println("Input c");
        double c=scanner.nextDouble();
        if (a!=0){
            double answer=(c-a)/b;
            System.out.printf("Equation pass with x = %f!\n", answer);
        } else {
            if (b==0){
                System.out.println("The solution is all x");
            } else {
                System.out.println("Not solution");
            }
        }
    }
}
