package bai2_Vong_Lap_Trong_Java.Bai_Tap;
import java.util.Scanner;
public class Hien_thi_cac_SNT_nho_hon_100 {
    public static void main(String[] args) {

        int N=2;
        while (N<100){
            boolean check=true;
            for (int i=2;i<N;i++){
                if (N%i==0){
                    check=false;
                }
            }
            if (check){
                System.out.println(N);

            }
            N++;
        }
    }
}
