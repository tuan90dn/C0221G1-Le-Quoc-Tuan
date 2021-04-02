package bai3_Loop_Array_Method.Thuc_hanh;
import java.util.Scanner;
public class Method_tim_min_trong_mang {
    public static int min(int [] array){
        int min = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] <min) {
                min = array[j];
            }
        }
        return min;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
//        int index = min(arr);
        System.out.println("The smallest element in the array is: " + min(arr));
    }
}
