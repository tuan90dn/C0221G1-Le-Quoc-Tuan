package bai2_Vong_Lap_Trong_Java.Bai_Tap;
import java.util.Scanner;
public class Hien_thi_cac_loai_hinh {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int choice;

        while (true){
            System.out.println("Menu");
            System.out.println("1. Draw the rectangle");
            System.out.println("2. Draw the square triangle");
            System.out.println("3. Draw isosceles triangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    for (int i=0;i<3;i++){
                        for (int j=0;j<7;j++){
                            System.out.print("* ");
                        }
                        System.out.println("\n");
                    }
                    break;
                case 2:
                    for (int i=0;i<6;i++){
                        for (int j=0;j<i;j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i=5;i>0;i--){
                        for (int j=0;j<i;j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }

        }

    }
}
