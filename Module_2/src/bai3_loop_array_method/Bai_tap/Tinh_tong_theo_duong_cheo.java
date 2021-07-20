package bai3_Loop_Array_Method.Bai_tap;

import java.util.Scanner;

public class Tinh_tong_theo_duong_cheo {
    public static void main(String[] args) {
        int m;
        int n;
        long tong=0;
        int[][] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập số hàng của mảng:");
            m = scanner.nextInt();
            System.out.print("Nhập số cột của mảng:");
            n = scanner.nextInt();
            if (m > 20 && n > 20)
                System.out.println("Size should not exceed 20");
        } while (m > 20 && n > 20);
        array = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print("Nhập phần tử của mảng:");
                array[x][y] = scanner.nextInt();
            }
        }

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if(i==j){
                    tong+=array[i][j];
                }
            }
        }
        System.out.println("Tổng cần tìm là "+tong);

    }
}
