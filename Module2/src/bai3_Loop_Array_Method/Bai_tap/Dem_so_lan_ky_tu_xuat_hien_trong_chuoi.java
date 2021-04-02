package bai3_Loop_Array_Method.Bai_tap;
import java.util.Scanner;
public class Dem_so_lan_ky_tu_xuat_hien_trong_chuoi {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String string="anhyeuem";
        System.out.println("Nhập ký tự cần tìm ");
        char c = scanner.next().charAt(0);
        int count=0;
        for (int i=0;i<string.length();i++){
            if (c==string.charAt(i)){
                count++;
            }
        }
        System.out.println("Số lần xuất hiện là "+count);
    }
}
