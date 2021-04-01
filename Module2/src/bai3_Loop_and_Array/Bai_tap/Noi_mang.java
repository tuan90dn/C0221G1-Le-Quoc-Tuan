package bai3_Loop_and_Array.Bai_tap;
import java.util.Scanner;
public class Noi_mang {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] arr1=new int[5];
        int[] arr2=new int[5];
        int[] arr3=new int[10];
        int i = 0;
        int j = 0;
        while (i < arr1.length) {
            System.out.print("Enter element " + (i + 1) + " of array 1: ");
            arr1[i] = scanner.nextInt();
            i++;
        }
        System.out.print("Array 1 is : ");
        for (int x = 0; x < arr1.length; x++) {
            System.out.print(arr1[x] + "\t");
            arr3[x]=arr1[x];
        }
        while (j < arr2.length) {
            System.out.print("\nEnter element " + (j + 1) + " of array 2: ");
            arr2[j] = scanner.nextInt();
            j++;
        }
        System.out.print("Array 2 is: ");
        for (int y = 0; y < arr2.length; y++) {
            System.out.print(arr2[y] + "\t");
            arr3[arr1.length+y]=arr2[y];
        }
        System.out.print("Array 3 is : ");
        for (int z = 0; z < arr3.length; z++) {
            System.out.print(arr3[z] + "\t");
        }

    }
}
