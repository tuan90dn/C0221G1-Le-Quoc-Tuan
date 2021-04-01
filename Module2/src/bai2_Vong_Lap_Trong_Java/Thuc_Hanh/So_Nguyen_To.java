package bai2_Vong_Lap_Trong_Java.Thuc_Hanh;
import java.util.Scanner;
public class So_Nguyen_To {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=scanner.nextInt();
        boolean check=false;
        if (num<2){
            check = true;
        } else {
            for (int i=2;i<=Math.sqrt(num);i++){
                if (num%i==0){
                    check = true;
                    break;
                }
            }
        }
        if (check){
            System.out.println(num+" is not a prime");
        } else {
            System.out.println(num+" is a prime");
        }
    }
}
