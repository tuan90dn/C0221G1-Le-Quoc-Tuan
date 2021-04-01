package bai2_Vong_Lap_Trong_Java.Thuc_Hanh;
import java.util.Scanner;
public class Tinh_tien_lai_cho_vay {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        double money;
        int month;
        double interset_rate;
        System.out.println("Enter investment amount: ");
        money = input.nextDouble();
        System.out.println("Enter number of months: ");
        month = input.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interset_rate = input.nextDouble();
        double total_interset = 0;
        for(int i = 0; i < month; i++){
            total_interset += money * (interset_rate/100)/12 * month;
        }
        System.out.println("Total of interset: " + total_interset);
    }
}
