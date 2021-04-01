package bai3_Loop_and_Array.Bai_tap;

import java.util.Scanner;

public class Xoa_phan_tu_trong_mang {
    public static void main(String[] args) {
        int[] numbers = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        int[] numbers1=new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();
        int temp=0;
        boolean isExist = false;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                System.out.println("Position of the num in the array " + num + " is: " + (i + 1));
                temp=i;
                isExist = true;
                break;
            }
        }
        if (isExist) {
//            numbers1[numbers1.length-1]=0;
            for (int i=0;i<temp;i++){
                numbers1[i]=numbers[i];
            }
            for (int i=temp;i<numbers1.length-1;i++){
                numbers1[i]=numbers[i+1];
            }
        }
        System.out.println("Mảng mới thành lập là ");
        for (int j = 0; j < numbers1.length; j++) {
            System.out.print(numbers1[j] + "\t");
        }
    }
}
