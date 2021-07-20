package bai3_Loop_Array_Method.Bai_tap;

import java.util.Scanner;

public class Tim_phan_tu_nho_nhat_trong_mang {
    public static int min(int[][] array) {
        int min = array[0][0];
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] <min) {
                    min = array[i][j];
                }
            }
        return min;
    }

    public static void main(String[] args) {
        int m;
        int n;
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
        System.out.println("Phần tử nhỏ nhất của mảng là: " + min(array));
    }
}
