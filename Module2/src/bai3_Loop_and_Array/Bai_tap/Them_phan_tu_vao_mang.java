package bai3_Loop_and_Array.Bai_tap;
import java.util.Scanner;
public class Them_phan_tu_vao_mang {
    public static void main(String[] args) {
        int[] numbers = {10, 4, 6, 7, 8, 6, 0, 0, 0, 0};
        int[] numbers1=new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int num = scanner.nextInt();
        System.out.println("Enter index");
        int index=scanner.nextInt();

        boolean isExist = false;
        for (int i=0;i<index-1;i++){
            numbers1[i]=numbers[i];
        }
        for (int i=index;i<numbers1.length-1;i++){
            numbers1[i]=numbers[i-1];
        }
        numbers1[index-1]=num;

        System.out.println("Mảng mới thành lập là ");
        for (int j = 0; j < numbers1.length; j++) {
            System.out.print(numbers1[j] + "\t");
        }
    }
}
