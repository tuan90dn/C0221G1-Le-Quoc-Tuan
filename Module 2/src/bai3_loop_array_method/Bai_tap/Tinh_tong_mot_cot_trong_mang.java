package bai3_Loop_Array_Method.Bai_tap;

import java.util.Scanner;

public class Tinh_tong_mot_cot_trong_mang {
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
        System.out.println("Nhập số thứ tự của cột cần tính tổng");
        int a=scanner.nextInt();
        for (int i=0;i<m;i++){
            tong+=array[i][a];
        }
        System.out.println("Tổng cần tìm là "+tong);

    }
}
