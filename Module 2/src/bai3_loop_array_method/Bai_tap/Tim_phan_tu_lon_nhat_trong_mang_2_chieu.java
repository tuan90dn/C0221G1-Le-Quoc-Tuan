package bai3_Loop_Array_Method.Bai_tap;

import java.util.Scanner;

public class Tim_phan_tu_lon_nhat_trong_mang_2_chieu {
    public static int max(int [][] array) {
        int max = array[0][0];
        for (int i=0;i<array.length;i++)
        for (int j = 0; j < array[i].length; j++) {
            if (array[i][j] > max) {
                max = array[i][j];
            }
        }
        return max;
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
            if (m > 20&&n>20)
                System.out.println("Size should not exceed 20");
        } while (m > 20&&n>20);
        array = new int[m][n];
        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){
                System.out.print("Nhập phần tử của mảng:");
                array[x][y]=scanner.nextInt();
            }
        }
        System.out.println("Phần tử lớn nhất của mảng là: " + max(array));
//        System.out.print("Property list: ");
//        for (int j = 0; j < array.length; j++) {
//            System.out.print(array[j] + "\t");
//        }


//        int max = array[0];
//        int index = 1;
//        for (int j = 0; j < array.length; j++) {
//            if (array[j] > max) {
//                max = array[j];
//                index = j + 1;
//            }
//        }
//        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
