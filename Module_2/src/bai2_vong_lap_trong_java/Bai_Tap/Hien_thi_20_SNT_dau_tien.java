package bai2_Vong_Lap_Trong_Java.Bai_Tap;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.Scanner;
public class Hien_thi_20_SNT_dau_tien {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Nhập số lượng SNT cần tìm: ");
        int num=input.nextInt();
        int count=0;
        int N=2;
        while (count<num){
            boolean check=true;
            for (int i=2;i<N;i++){
                if (N%i==0){
                    check=false;
                }
            }
            if (check){
                System.out.println(N);
                count++;
            }
            N++;
        }
    }
}
