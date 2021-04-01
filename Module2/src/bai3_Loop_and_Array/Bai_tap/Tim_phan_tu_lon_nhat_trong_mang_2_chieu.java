package bai3_Loop_and_Array.Bai_tap;

import java.util.Scanner;

public class Tim_phan_tu_lon_nhat_trong_mang_2_chieu {
    public static void main(String[] args) {
        int m;
        int n;
        int[] array;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Nhập số hàng của mảng:");
            m = scanner.nextInt();
            System.out.print("Nhập số cột của mảng:");
            n = scanner.nextInt();
            if (m > 20&&n>20)
                System.out.println("Size should not exceed 20");
        } while (m > 20&&n>20);
        array = new int[m];
        for (int x=0;x<array.length;x++){
            int[] array[x]=new int[n];
            int i = 0;
            while (i < array.length) {
                System.out.print("Enter element" + (i + 1) + " : ");
                array[i] = scanner.nextInt();
                i++;
            }
        }

        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + " ,at position " + index);
    }
}
